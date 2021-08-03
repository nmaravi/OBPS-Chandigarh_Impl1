package org.egov.edcr.feature;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.egov.common.entity.edcr.Block;
import org.egov.common.entity.edcr.Flight;
import org.egov.common.entity.edcr.Floor;
import org.egov.common.entity.edcr.Measurement;
import org.egov.common.entity.edcr.OccupancyTypeHelper;
import org.egov.common.entity.edcr.Plan;
import org.egov.common.entity.edcr.Result;
import org.egov.common.entity.edcr.ScrutinyDetail;
import org.egov.common.entity.edcr.StairLanding;
import org.egov.edcr.constants.DxfFileConstants;
import org.egov.edcr.service.cdg.CDGAConstant;
import org.egov.edcr.service.cdg.CDGAdditionalService;
import org.egov.edcr.utility.DcrConstants;
import org.egov.edcr.utility.Util;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

@Service
public class GeneralStair extends FeatureProcess {
	private static final Logger LOG = Logger.getLogger(GeneralStair.class);
	private static final String FLOOR = "Floor";
	private static final String RULE42_5_II = "42-5-ii";
	private static final String EXPECTED_NO_OF_RISER = "12";
	private static final String NO_OF_RISER_DESCRIPTION = "Maximum no of risers required per flight for general stair %s flight %s";
	private static final String HEIGHT_OF_RISER_DESCRIPTION = "Maximum permissible riser height for general stair %s";
	private static final String WIDTH_DESCRIPTION = "Minimum width for general stair %s flight %s";
	private static final String TREAD_DESCRIPTION = "Minimum tread for general stair %s flight %s";
	private static final String NO_OF_RISERS = "Number of risers ";
	private static final String FLIGHT_POLYLINE_NOT_DEFINED_DESCRIPTION = "Flight polyline is not defined in layer ";
	private static final String FLIGHT_LENGTH_DEFINED_DESCRIPTION = "Flight polyline length is not defined in layer ";
	private static final String FLIGHT_WIDTH_DEFINED_DESCRIPTION = "Flight polyline width is not defined in layer ";
	private static final String WIDTH_LANDING_DESCRIPTION = "Minimum width for general stair %s mid landing %s";
	private static final String FLIGHT_NOT_DEFINED_DESCRIPTION = "General stair flight is not defined in block %s floor %s";

	@Override
	public Plan validate(Plan plan) {
		if(!CDGAdditionalService.isFeatureValidationRequired(plan, GeneralStair.class))
			return plan;
		for(Block block:plan.getBlocks()) {
			for(Floor floor:block.getBuilding().getFloors()) {
				if(floor.getNumber()<0) {
					if(floor.getGeneralStairs()==null || floor.getGeneralStairs().size()<2) {
						plan.addError("MINIMUM_TWO_STAIR_Required"+block.getNumber()+"f"+floor.getNumber(), "Minimum two GenralStair are required in blook "+block.getNumber()+" Floor "+floor.getNumber()+" but provided "+floor.getGeneralStairs().size());
					}
				}
			}
		}
		
		return plan;
	}

	@Override
	public Plan process(Plan plan) {
		if(!CDGAdditionalService.isFeatureValidationRequired(plan, GeneralStair.class))
			return plan;
		validate(plan);
		HashMap<String, String> errors = new HashMap<>();
		blk: for (Block block : plan.getBlocks()) {
			int generalStairCount = 0;

			if (block.getBuilding() != null) {
				/*
				 * if (Util.checkExemptionConditionForBuildingParts(block) ||
				 * Util.checkExemptionConditionForSmallPlotAtBlkLevel(planDetail.getPlot(),
				 * block)) { continue blk; }
				 */
				ScrutinyDetail scrutinyDetail2 = new ScrutinyDetail();
				scrutinyDetail2.addColumnHeading(1, RULE_NO);
				scrutinyDetail2.addColumnHeading(2, FLOOR);
				scrutinyDetail2.addColumnHeading(3, DESCRIPTION);
				scrutinyDetail2.addColumnHeading(4, PERMISSIBLE);
				scrutinyDetail2.addColumnHeading(5, PROVIDED);
				scrutinyDetail2.addColumnHeading(6, STATUS);
				scrutinyDetail2.setKey("Block_" + block.getNumber() + "_" + "General Stair - Width");

				ScrutinyDetail scrutinyDetail3 = new ScrutinyDetail();
				scrutinyDetail3.addColumnHeading(1, RULE_NO);
				scrutinyDetail3.addColumnHeading(2, FLOOR);
				scrutinyDetail3.addColumnHeading(3, DESCRIPTION);
				scrutinyDetail3.addColumnHeading(4, PERMISSIBLE);
				scrutinyDetail3.addColumnHeading(5, PROVIDED);
				scrutinyDetail3.addColumnHeading(6, STATUS);
				scrutinyDetail3.setKey("Block_" + block.getNumber() + "_" + "General Stair - Tread width");

				ScrutinyDetail scrutinyDetailRise = new ScrutinyDetail();
				scrutinyDetailRise.addColumnHeading(1, RULE_NO);
				scrutinyDetailRise.addColumnHeading(2, FLOOR);
				scrutinyDetailRise.addColumnHeading(3, DESCRIPTION);
				scrutinyDetailRise.addColumnHeading(4, PERMISSIBLE);
				scrutinyDetailRise.addColumnHeading(5, PROVIDED);
				scrutinyDetailRise.addColumnHeading(6, STATUS);
				scrutinyDetailRise.setKey("Block_" + block.getNumber() + "_" + "General Stair - Number of risers");
				
				ScrutinyDetail scrutinyDetailHeightRise = new ScrutinyDetail();
				scrutinyDetailHeightRise.addColumnHeading(1, RULE_NO);
				scrutinyDetailHeightRise.addColumnHeading(2, FLOOR);
				scrutinyDetailHeightRise.addColumnHeading(3, DESCRIPTION);
				scrutinyDetailHeightRise.addColumnHeading(4, PERMISSIBLE);
				scrutinyDetailHeightRise.addColumnHeading(5, PROVIDED);
				scrutinyDetailHeightRise.addColumnHeading(6, STATUS);
				scrutinyDetailHeightRise.setKey("Block_" + block.getNumber() + "_" + "General Stair - Height of risers");

				ScrutinyDetail scrutinyDetailLanding = new ScrutinyDetail();
				scrutinyDetailLanding.addColumnHeading(1, RULE_NO);
				scrutinyDetailLanding.addColumnHeading(2, FLOOR);
				scrutinyDetailLanding.addColumnHeading(3, DESCRIPTION);
				scrutinyDetailLanding.addColumnHeading(4, PERMISSIBLE);
				scrutinyDetailLanding.addColumnHeading(5, PROVIDED);
				scrutinyDetailLanding.addColumnHeading(6, STATUS);
				scrutinyDetailLanding.setKey("Block_" + block.getNumber() + "_" + "General Stair - Mid landing");

				OccupancyTypeHelper mostRestrictiveOccupancyType = block.getBuilding() != null
						? block.getBuilding().getMostRestrictiveFarHelper()
						: null;

				/*
				 * String occupancyType = mostRestrictiveOccupancy != null ?
				 * mostRestrictiveOccupancy.getOccupancyType() : null;
				 */

				List<Floor> floors = block.getBuilding().getFloors();
				List<String> stairAbsent = new ArrayList<>();
				// BigDecimal floorSize = block.getBuilding().getFloorsAboveGround();

				if (!isOccupancyTypehNotApplicable(mostRestrictiveOccupancyType)) {
					for (Floor floor : floors) {
						if (!floor.getTerrace()) {

							boolean isTypicalRepititiveFloor = false;
							Map<String, Object> typicalFloorValues = Util.getTypicalFloorValues(block, floor,
									isTypicalRepititiveFloor);

							List<org.egov.common.entity.edcr.GeneralStair> generalStairs = floor.getGeneralStairs();

							int size = generalStairs.size();
							generalStairCount = generalStairCount + size;

							if (!generalStairs.isEmpty()) {
								validateHeightOfRiser(plan, block, floor, scrutinyDetailHeightRise, mostRestrictiveOccupancyType, errors);
								for (org.egov.common.entity.edcr.GeneralStair generalStair : generalStairs) {
									{
										validateFlight(plan, errors, block, scrutinyDetail2, scrutinyDetail3,
												scrutinyDetailRise, mostRestrictiveOccupancyType, floor,
												typicalFloorValues, generalStair);
										
										List<StairLanding> landings = generalStair.getLandings();
										if (!landings.isEmpty()) {
											validateLanding(plan, block, scrutinyDetailLanding,
													mostRestrictiveOccupancyType, floor, typicalFloorValues,
													generalStair, landings, errors);
										} else {
											errors.put(
													"General Stair landing not defined in block " + block.getNumber()
															+ " floor " + floor.getNumber() + " stair "
															+ generalStair.getNumber(),
													"General Stair landing not defined in block " + block.getNumber()
															+ " floor " + floor.getNumber() + " stair "
															+ generalStair.getNumber());
											plan.addErrors(errors);
										}

									}
								}
							} else if(!isStairOptional(plan, block, floor)){
								stairAbsent.add("Block " + block.getNumber() + " floor " + floor.getNumber());
							}

						}
					}

					if (block.getBuilding().getFloors().size() > 1 && !stairAbsent.isEmpty()) {
						for (String error : stairAbsent) {
							errors.put("General Stair " + error, "General stair not defined in " + error);
							plan.addErrors(errors);
						}
					}

					if (block.getBuilding().getFloors().size() > 1 && generalStairCount == 0) {
						errors.put("General Stair not defined in blk " + block.getNumber(),
								"General Stair not defined in block " + block.getNumber()
										+ ", it is mandatory for building with floors more than one.");
						plan.addErrors(errors);
					} //
				}

			}
		}

		return plan;
	}
	
	public boolean isStairOptional(Plan plan,Block block, Floor floor) {
		boolean flage=false;
		OccupancyTypeHelper occupancyTypeHelper=plan.getVirtualBuilding().getMostRestrictiveFarHelper();
		
		if(DxfFileConstants.A_P.equals(occupancyTypeHelper.getSubtype().getCode()) || DxfFileConstants.F_SCO.equals(occupancyTypeHelper.getSubtype().getCode())) {
			int tf=block.getBuilding().getFloorsAboveGround().intValue()-1;
			if(tf==floor.getNumber()) 
				if(block.getStairCovers()==null || block.getStairCovers().isEmpty())
					flage=true;
			
		}
		return flage;
	}

	private boolean isOccupancyTypehNotApplicable(OccupancyTypeHelper occupancyTypeHelper) {
		boolean flage = false;

		if (DxfFileConstants.F_PP.equals(occupancyTypeHelper.getSubtype().getCode())
				|| DxfFileConstants.F_CD.equals(occupancyTypeHelper.getSubtype().getCode())
				|| DxfFileConstants.T1.equals(occupancyTypeHelper.getSubtype().getCode())
				|| DxfFileConstants.G_GBAC.equals(occupancyTypeHelper.getSubtype().getCode()))
			flage = true;

		return flage;
	}

	private void validateLanding(Plan plan, Block block, ScrutinyDetail scrutinyDetailLanding,
			OccupancyTypeHelper mostRestrictiveOccupancyType, Floor floor, Map<String, Object> typicalFloorValues,
			org.egov.common.entity.edcr.GeneralStair generalStair, List<StairLanding> landings,
			HashMap<String, String> errors) {
		for (StairLanding landing : landings) {
			List<BigDecimal> widths = landing.getWidths();
			if (!widths.isEmpty()) {
				BigDecimal landingWidth = widths.stream().reduce(BigDecimal::min).get();
				BigDecimal minWidth = BigDecimal.ZERO;
				boolean valid = false;

				if (!(Boolean) typicalFloorValues.get("isTypicalRepititiveFloor")) {
					minWidth = Util.roundOffTwoDecimal(landingWidth);
					BigDecimal minimumWidth = getRequiredWidth(plan,block, mostRestrictiveOccupancyType);
					
					if(plan.getDrawingPreference().getInFeets()) {
						minWidth=CDGAdditionalService.inchToFeet(minWidth);
						minimumWidth=CDGAdditionalService.meterToFoot(minimumWidth);
					}

					if (minWidth.compareTo(minimumWidth) >= 0) {
						valid = true;
					}
					String value = typicalFloorValues.get("typicalFloors") != null
							? (String) typicalFloorValues.get("typicalFloors")
							: " floor " + floor.getNumber();

					if (valid) {
						setReportOutputDetailsFloorStairWise(plan,
								CDGAdditionalService.getByLaws(mostRestrictiveOccupancyType, CDGAConstant.STAIRCASE),
								value,
								String.format(WIDTH_LANDING_DESCRIPTION, generalStair.getNumber(), landing.getNumber()),
								CDGAdditionalService.viewLenght(plan, minimumWidth), CDGAdditionalService.viewLenght(plan, minWidth), Result.Accepted.getResultVal(),
								scrutinyDetailLanding);
					} else {
						setReportOutputDetailsFloorStairWise(plan,
								CDGAdditionalService.getByLaws(mostRestrictiveOccupancyType, CDGAConstant.STAIRCASE),
								value,
								String.format(WIDTH_LANDING_DESCRIPTION, generalStair.getNumber(), landing.getNumber()),
								CDGAdditionalService.viewLenght(plan, minimumWidth), CDGAdditionalService.viewLenght(plan, minWidth), Result.Not_Accepted.getResultVal(),
								scrutinyDetailLanding);
					}
				}
			} else {
				errors.put("General Stair landing width not defined in block " + block.getNumber() + " floor "
						+ floor.getNumber() + " stair " + generalStair.getNumber() + " Landing " + landing.getNumber(),
						"General Stair landing width not defined in block " + block.getNumber() + " floor "
								+ floor.getNumber() + " stair " + generalStair.getNumber() + " Landing "
								+ landing.getNumber());
				plan.addErrors(errors);
			}
		}
	}

	
	private void validateHeightOfRiser(Plan pl,Block block,Floor floor,ScrutinyDetail scrutinyDetailHeightRise,OccupancyTypeHelper occupancyTypeHelper,HashMap<String, String> errors) {
		
		
		List<org.egov.common.entity.edcr.GeneralStair> generalStairs = floor.getGeneralStairs();
		
		for(org.egov.common.entity.edcr.GeneralStair generalStair:generalStairs) {
			BigDecimal totalNoOfRaiser=BigDecimal.ZERO;
			for(Flight flight:generalStair.getFlights()) {
				totalNoOfRaiser=totalNoOfRaiser.add(flight.getNoOfRises());
			}
			
			BigDecimal raiserHeightProvided=BigDecimal.ZERO;
			
			if(totalNoOfRaiser.compareTo(BigDecimal.ZERO)<=0) {
				pl.addError("STAIRCASE", " Raiser not defined Block "+block.getNumber()+" floor "+ floor.getNumber()+" stair "+generalStair.getNumber());
				return;
			}
			
			if(generalStair.getFloorHeight()==null) {
				pl.addError("FloorHeight", "FloorHeight not defined. generalStair - "+generalStair.getNumber());
				return;
			}
			
			if(generalStair.getFloorHeight().compareTo(BigDecimal.ZERO)>0)
			raiserHeightProvided=generalStair.getFloorHeight().divide(totalNoOfRaiser,BigDecimal.ROUND_HALF_UP); 
			else
				pl.addError("STAIRCASE", " Floor Hight not defined Block "+block.getNumber()+" floor "+ floor.getNumber()+" stair "+generalStair.getNumber());
			BigDecimal raiserHeightexpected=requiredRaiserHeight(occupancyTypeHelper,pl.getDrawingPreference().getInFeets());
			
//			if(pl.getDrawingPreference().getInFeets()) {
//				raiserHeightProvided=CDGAdditionalService.inchToFeet(raiserHeightProvided);
//				raiserHeightexpected=CDGAdditionalService.meterToFoot(raiserHeightexpected);
//			}
			
			boolean valid=false;
			if(raiserHeightProvided.compareTo(raiserHeightexpected)<=0)
				valid=true;
			
			if(valid)
				setReportOutputDetailsFloorStairWise(pl, CDGAdditionalService.getByLaws(occupancyTypeHelper, CDGAConstant.STAIRCASE), floor.getNumber().toString(),String.format(HEIGHT_OF_RISER_DESCRIPTION, generalStair.getNumber()) ,CDGAdditionalService.viewLenght(pl, raiserHeightexpected), CDGAdditionalService.viewLenght(pl, raiserHeightProvided), Result.Accepted.getResultVal(), scrutinyDetailHeightRise);
			else
				setReportOutputDetailsFloorStairWise(pl, CDGAdditionalService.getByLaws(occupancyTypeHelper, CDGAConstant.STAIRCASE), floor.getNumber().toString(),String.format(HEIGHT_OF_RISER_DESCRIPTION, generalStair.getNumber()), CDGAdditionalService.viewLenght(pl, raiserHeightexpected), CDGAdditionalService.viewLenght(pl, raiserHeightProvided), Result.Not_Accepted.getResultVal(), scrutinyDetailHeightRise);
			
			
		}
		
		
		
	}
	
	private BigDecimal requiredRaiserHeight(OccupancyTypeHelper occupancyTypeHelper,Boolean isInFeet) {
		
		if(isInFeet) {
			if(DxfFileConstants.A_P.equals(occupancyTypeHelper.getSubtype().getCode())) 
				return new BigDecimal("0.63");
			else if(DxfFileConstants.A_G.equals(occupancyTypeHelper.getSubtype().getCode())
					|| DxfFileConstants.F_SCO.equals(occupancyTypeHelper.getSubtype().getCode())
					|| DxfFileConstants.F_B.equals(occupancyTypeHelper.getSubtype().getCode())
					|| DxfFileConstants.ITH_R.equals(occupancyTypeHelper.getSubtype().getCode())
					) 
				return new BigDecimal("0.58");
			else if(DxfFileConstants.F_H.equals(occupancyTypeHelper.getSubtype().getCode())
					|| DxfFileConstants.F_M.equals(occupancyTypeHelper.getSubtype().getCode())
					|| DxfFileConstants.F_CFI.equals(occupancyTypeHelper.getSubtype().getCode())
					|| DxfFileConstants.F_BH.equals(occupancyTypeHelper.getSubtype().getCode())
					|| DxfFileConstants.F_BBM.equals(occupancyTypeHelper.getSubtype().getCode())
					|| DxfFileConstants.F_TS.equals(occupancyTypeHelper.getSubtype().getCode())
					|| DxfFileConstants.F_TCIM.equals(occupancyTypeHelper.getSubtype().getCode())
					|| DxfFileConstants.G_GBZP.equals(occupancyTypeHelper.getSubtype().getCode())
					|| DxfFileConstants.P_D.equals(occupancyTypeHelper.getSubtype().getCode())
					|| DxfFileConstants.P_P.equals(occupancyTypeHelper.getSubtype().getCode())
					|| DxfFileConstants.P_F.equals(occupancyTypeHelper.getSubtype().getCode())
					|| DxfFileConstants.P_N.equals(occupancyTypeHelper.getSubtype().getCode())
					|| DxfFileConstants.P_H.equals(occupancyTypeHelper.getSubtype().getCode())
					|| DxfFileConstants.P_CNA.equals(occupancyTypeHelper.getSubtype().getCode())
					|| DxfFileConstants.F_BH.equals(occupancyTypeHelper.getSubtype().getCode())
					) 
				return new BigDecimal("0.5");
			else
				return new BigDecimal("0.5");
		}else {
			if(DxfFileConstants.A_P.equals(occupancyTypeHelper.getSubtype().getCode())) 
				return BigDecimal.valueOf(0.19);
			else if(DxfFileConstants.A_G.equals(occupancyTypeHelper.getSubtype().getCode())
					|| DxfFileConstants.F_SCO.equals(occupancyTypeHelper.getSubtype().getCode())
					|| DxfFileConstants.F_B.equals(occupancyTypeHelper.getSubtype().getCode())
					|| DxfFileConstants.ITH_R.equals(occupancyTypeHelper.getSubtype().getCode())
					) 
				return BigDecimal.valueOf(0.175);
			else if(DxfFileConstants.F_H.equals(occupancyTypeHelper.getSubtype().getCode())
					|| DxfFileConstants.F_M.equals(occupancyTypeHelper.getSubtype().getCode())
					|| DxfFileConstants.F_CFI.equals(occupancyTypeHelper.getSubtype().getCode())
					|| DxfFileConstants.F_BH.equals(occupancyTypeHelper.getSubtype().getCode())
					|| DxfFileConstants.F_BBM.equals(occupancyTypeHelper.getSubtype().getCode())
					|| DxfFileConstants.F_TS.equals(occupancyTypeHelper.getSubtype().getCode())
					|| DxfFileConstants.F_TCIM.equals(occupancyTypeHelper.getSubtype().getCode())
					|| DxfFileConstants.G_GBZP.equals(occupancyTypeHelper.getSubtype().getCode())
					|| DxfFileConstants.P_D.equals(occupancyTypeHelper.getSubtype().getCode())
					|| DxfFileConstants.P_P.equals(occupancyTypeHelper.getSubtype().getCode())
					|| DxfFileConstants.P_F.equals(occupancyTypeHelper.getSubtype().getCode())
					|| DxfFileConstants.P_N.equals(occupancyTypeHelper.getSubtype().getCode())
					|| DxfFileConstants.P_H.equals(occupancyTypeHelper.getSubtype().getCode())
					|| DxfFileConstants.P_CNA.equals(occupancyTypeHelper.getSubtype().getCode())
					|| DxfFileConstants.F_BH.equals(occupancyTypeHelper.getSubtype().getCode())
					) 
				return BigDecimal.valueOf(0.15);
			else
				return BigDecimal.valueOf(0.15);
		}
		
	}
	
	
	private void validateFlight(Plan plan, HashMap<String, String> errors, Block block, ScrutinyDetail scrutinyDetail2,
			ScrutinyDetail scrutinyDetail3, ScrutinyDetail scrutinyDetailRise, 
			OccupancyTypeHelper mostRestrictiveOccupancyType, Floor floor, Map<String, Object> typicalFloorValues,
			org.egov.common.entity.edcr.GeneralStair generalStair) {
		if (!generalStair.getFlights().isEmpty()) {
			for (Flight flight : generalStair.getFlights()) {
				List<Measurement> flightPolyLines = flight.getFlights();
				List<BigDecimal> flightLengths = flight.getLengthOfFlights();
				List<BigDecimal> flightWidths = flight.getWidthOfFlights();
				BigDecimal noOfRises = flight.getNoOfRises();
				Boolean flightPolyLineClosed = flight.getFlightClosed();

				BigDecimal minTread = BigDecimal.ZERO;
				BigDecimal minFlightWidth = BigDecimal.ZERO;
				String flightLayerName = String.format(DxfFileConstants.LAYER_STAIR_FLIGHT, block.getNumber(),
						floor.getNumber(), generalStair.getNumber(), flight.getNumber());

//                if (flightPolyLines != null) {
				if (flightPolyLines != null && flightPolyLines.size() > 0) {
					if (flightPolyLineClosed) {
						if (flightWidths != null && flightWidths.size() > 0) {
							minFlightWidth = validateWidth(plan, scrutinyDetail2, floor, block, typicalFloorValues,
									generalStair, flight, flightWidths, minFlightWidth, mostRestrictiveOccupancyType);

						} else {
							errors.put("Flight PolyLine width" + flightLayerName,
									FLIGHT_WIDTH_DEFINED_DESCRIPTION + flightLayerName);
							plan.addErrors(errors);
						}

						/*
						 * (Total length of polygons in layer BLK_n_FLR_i_STAIR_k_FLIGHT) / (Number of
						 * rises - number of polygons in layer BLK_n_FLR_i_STAIR_k_FLIGHT - number of
						 * lines in layer BLK_n_FLR_i_STAIR_k_FLIGHT)
						 */

						if (flightLengths != null && flightLengths.size() > 0) {
							try {
								minTread = validateTread(plan, errors, block, scrutinyDetail3, floor,
										typicalFloorValues, generalStair, flight, flightLengths, minTread,
										mostRestrictiveOccupancyType);
							} catch (ArithmeticException e) {
								LOG.error("Denominator is zero");
							}
						} else {
							errors.put("Flight PolyLine length" + flightLayerName,
									FLIGHT_LENGTH_DEFINED_DESCRIPTION + flightLayerName);
							plan.addErrors(errors);

						}

						if (noOfRises.compareTo(BigDecimal.ZERO) > 0) {
							try {
								validateNoOfRises(plan, errors, block, scrutinyDetailRise, floor, typicalFloorValues,
										generalStair, flight, noOfRises);
							} catch (ArithmeticException e) {
								LOG.error("Denominator is zero");
							}
						} else {
							/*
							 * String layerName = String.format( DxfFileConstants.LAYER_STAIR_FLIGHT,
							 * block.getNumber(), floor.getNumber(), generalStair.getNumber(),
							 * flight.getNumber());
							 */
							errors.put("noofRise" + flightLayerName,
									edcrMessageSource.getMessage(DcrConstants.OBJECTNOTDEFINED,
											new String[] { NO_OF_RISERS + flightLayerName },
											LocaleContextHolder.getLocale()));
							plan.addErrors(errors);
						}

					}
				} else {
					errors.put("Flight PolyLine " + flightLayerName,
							FLIGHT_POLYLINE_NOT_DEFINED_DESCRIPTION + flightLayerName);
					plan.addErrors(errors);
				}

			}
		} else {
			String error = String.format(FLIGHT_NOT_DEFINED_DESCRIPTION, block.getNumber(), floor.getNumber());
			errors.put(error, error);
			plan.addErrors(errors);
		}
	}

	private BigDecimal validateWidth(Plan plan, ScrutinyDetail scrutinyDetail2, Floor floor, Block block,
			Map<String, Object> typicalFloorValues, org.egov.common.entity.edcr.GeneralStair generalStair,
			Flight flight, List<BigDecimal> flightWidths, BigDecimal minFlightWidth,
			OccupancyTypeHelper mostRestrictiveOccupancyType) {
		BigDecimal flightPolyLine = flightWidths.stream().reduce(BigDecimal::min).get();

		boolean valid = false;

		if (!(Boolean) typicalFloorValues.get("isTypicalRepititiveFloor")) {
			minFlightWidth = Util.roundOffTwoDecimal(flightPolyLine);
			BigDecimal minimumWidth = getRequiredWidth(plan,block, mostRestrictiveOccupancyType);
			
			if(plan.getDrawingPreference().getInFeets()) {
				minFlightWidth=CDGAdditionalService.inchToFeet(minFlightWidth);
				minimumWidth=CDGAdditionalService.meterToFoot(minimumWidth);
			}

			if (minFlightWidth.compareTo(minimumWidth) >= 0) {
				valid = true;
			}
			String value = typicalFloorValues.get("typicalFloors") != null
					? (String) typicalFloorValues.get("typicalFloors")
					: " floor " + floor.getNumber();

			if (valid) {
				setReportOutputDetailsFloorStairWise(plan,
						CDGAdditionalService.getByLaws(mostRestrictiveOccupancyType, CDGAConstant.STAIRCASE), value,
						String.format(WIDTH_DESCRIPTION, generalStair.getNumber(), flight.getNumber()),
						CDGAdditionalService.viewLenght(plan, minimumWidth), CDGAdditionalService.viewLenght(plan, minFlightWidth), Result.Accepted.getResultVal(),
						scrutinyDetail2);
			} else {
				setReportOutputDetailsFloorStairWise(plan,
						CDGAdditionalService.getByLaws(mostRestrictiveOccupancyType, CDGAConstant.STAIRCASE), value,
						String.format(WIDTH_DESCRIPTION, generalStair.getNumber(), flight.getNumber()),
						CDGAdditionalService.viewLenght(plan, minimumWidth), CDGAdditionalService.viewLenght(plan, minFlightWidth), Result.Not_Accepted.getResultVal(),
						scrutinyDetail2);
			}
		}
		return minFlightWidth;
	}

	private BigDecimal getRequiredWidth(Plan pl, Block block, OccupancyTypeHelper mostRestrictiveOccupancyType) {

		if (DxfFileConstants.A_P.equals(mostRestrictiveOccupancyType.getSubtype().getCode())
				|| DxfFileConstants.F_SCO.equals(mostRestrictiveOccupancyType.getSubtype().getCode())
				|| DxfFileConstants.F_B.equals(mostRestrictiveOccupancyType.getSubtype().getCode()))
			return BigDecimal.valueOf(1.0);
		else if (DxfFileConstants.A_G.equals(mostRestrictiveOccupancyType.getSubtype().getCode()))
			return BigDecimal.valueOf(1.25);
		else if (DxfFileConstants.F_H.equals(mostRestrictiveOccupancyType.getSubtype().getCode())
				|| DxfFileConstants.F_BBM.equals(mostRestrictiveOccupancyType.getSubtype().getCode())
				|| DxfFileConstants.F_TS.equals(mostRestrictiveOccupancyType.getSubtype().getCode())
				|| DxfFileConstants.G_GBZP.equals(mostRestrictiveOccupancyType.getSubtype().getCode())
				|| DxfFileConstants.P_P.equals(mostRestrictiveOccupancyType.getSubtype().getCode())
				|| DxfFileConstants.P_F.equals(mostRestrictiveOccupancyType.getSubtype().getCode())
				|| DxfFileConstants.P_CNA.equals(mostRestrictiveOccupancyType.getSubtype().getCode())
				|| DxfFileConstants.P_R.equals(mostRestrictiveOccupancyType.getSubtype().getCode())
				|| DxfFileConstants.IT.equals(mostRestrictiveOccupancyType.getType().getCode())
				|| DxfFileConstants.ITH_R.equals(mostRestrictiveOccupancyType.getType().getCode())
				|| DxfFileConstants.ITH_GH.equals(mostRestrictiveOccupancyType.getType().getCode())
				|| DxfFileConstants.IP_R.equals(mostRestrictiveOccupancyType.getType().getCode()))
			return BigDecimal.valueOf(1.5);
		else if (DxfFileConstants.F_M.equals(mostRestrictiveOccupancyType.getSubtype().getCode())
				|| DxfFileConstants.F_M.equals(mostRestrictiveOccupancyType.getSubtype().getCode())
				|| DxfFileConstants.F_BH.equals(mostRestrictiveOccupancyType.getSubtype().getCode())
				|| DxfFileConstants.F_TCIM.equals(mostRestrictiveOccupancyType.getSubtype().getCode())
				|| DxfFileConstants.P_D.equals(mostRestrictiveOccupancyType.getSubtype().getCode())
				|| DxfFileConstants.P_N.equals(mostRestrictiveOccupancyType.getSubtype().getCode())
				|| DxfFileConstants.P_H.equals(mostRestrictiveOccupancyType.getSubtype().getCode())
				|| DxfFileConstants.P_CC.equals(mostRestrictiveOccupancyType.getSubtype().getCode())
				|| DxfFileConstants.P_SS.equals(mostRestrictiveOccupancyType.getSubtype().getCode())
				|| DxfFileConstants.ITH_H.equals(mostRestrictiveOccupancyType.getSubtype().getCode())
				|| DxfFileConstants.ITH_C.equals(mostRestrictiveOccupancyType.getSubtype().getCode())
				|| DxfFileConstants.ITH_CC.equals(mostRestrictiveOccupancyType.getSubtype().getCode())
				|| DxfFileConstants.IP_I.equals(mostRestrictiveOccupancyType.getSubtype().getCode())
				|| DxfFileConstants.IP_C.equals(mostRestrictiveOccupancyType.getSubtype().getCode()))
			return BigDecimal.valueOf(2.0);
		else if (DxfFileConstants.B.equals(mostRestrictiveOccupancyType.getType().getCode())) {
			BigDecimal numberOfPerson = CDGAdditionalService.getNumberOfPerson(pl);
			if (numberOfPerson.compareTo(BigDecimal.valueOf(200)) <= 0)
				return BigDecimal.valueOf(1.5);
			else
				return BigDecimal.valueOf(1.8);
		}else 
			return BigDecimal.ZERO;
	}

	private BigDecimal validateTread(Plan plan, HashMap<String, String> errors, Block block,
			ScrutinyDetail scrutinyDetail3, Floor floor, Map<String, Object> typicalFloorValues,
			org.egov.common.entity.edcr.GeneralStair generalStair, Flight flight, List<BigDecimal> flightLengths,
			BigDecimal minTread, OccupancyTypeHelper mostRestrictiveOccupancyType) {
		BigDecimal totalLength = flightLengths.stream().reduce(BigDecimal.ZERO, BigDecimal::add);

		totalLength = Util.roundOffTwoDecimal(totalLength);

		BigDecimal requiredTread = getRequiredTread(mostRestrictiveOccupancyType);
		
		if(plan.getDrawingPreference().getInFeets()) {
			totalLength=CDGAdditionalService.inchToFeet(totalLength);
			requiredTread=CDGAdditionalService.meterToFoot(requiredTread);
		}

		if (flight.getNoOfRises() != null) {
			/*
			 * BigDecimal denominator =
			 * fireStair.getNoOfRises().subtract(BigDecimal.valueOf(flightLengths.size()))
			 * .subtract(BigDecimal.valueOf(fireStair.getLinesInFlightLayer().size()));
			 */
			BigDecimal noOfFlights = BigDecimal.valueOf(flightLengths.size());

			if (flight.getNoOfRises().compareTo(noOfFlights) > 0) {
				BigDecimal denominator = flight.getNoOfRises().subtract(noOfFlights);

				minTread = totalLength.divide(denominator, DcrConstants.DECIMALDIGITS_MEASUREMENTS,
						DcrConstants.ROUNDMODE_MEASUREMENTS);

				boolean valid = false;

				if (!(Boolean) typicalFloorValues.get("isTypicalRepititiveFloor")) {

					if (Util.roundOffTwoDecimal(minTread).compareTo(Util.roundOffTwoDecimal(requiredTread)) >= 0) {
						valid = true;
					}

					String value = typicalFloorValues.get("typicalFloors") != null
							? (String) typicalFloorValues.get("typicalFloors")
							: " floor " + floor.getNumber();
					if (valid) {
						setReportOutputDetailsFloorStairWise(plan,
								CDGAdditionalService.getByLaws(mostRestrictiveOccupancyType, CDGAConstant.STAIRCASE),
								value, String.format(TREAD_DESCRIPTION, generalStair.getNumber(), flight.getNumber()),
								CDGAdditionalService.viewLenght(plan, requiredTread), CDGAdditionalService.viewLenght(plan, minTread), Result.Accepted.getResultVal(),
								scrutinyDetail3);
					} else {
						setReportOutputDetailsFloorStairWise(plan,
								CDGAdditionalService.getByLaws(mostRestrictiveOccupancyType, CDGAConstant.STAIRCASE),
								value, String.format(TREAD_DESCRIPTION, generalStair.getNumber(), flight.getNumber()),
								CDGAdditionalService.viewLenght(plan, requiredTread), CDGAdditionalService.viewLenght(plan, minTread), Result.Not_Accepted.getResultVal(),
								scrutinyDetail3);
					}
				}
			} else {
				if (flight.getNoOfRises().compareTo(BigDecimal.ZERO) > 0) {
					String flightLayerName = String.format(DxfFileConstants.LAYER_STAIR_FLIGHT, block.getNumber(),
							floor.getNumber(), generalStair.getNumber(), flight.getNumber());
					errors.put("NoOfRisesCount" + flightLayerName,
							"Number of risers count should be greater than the count of length of flight dimensions defined in layer "
									+ flightLayerName);
					plan.addErrors(errors);
				}
			}
		}
		return minTread;
	}

	private BigDecimal getRequiredTread(OccupancyTypeHelper mostRestrictiveOccupancyType) {
		if(DxfFileConstants.A_P.equals(mostRestrictiveOccupancyType.getSubtype().getCode())) {
			return BigDecimal.valueOf(0.25);
		}
		else if(DxfFileConstants.A_G.equals(mostRestrictiveOccupancyType.getSubtype().getCode())
				|| DxfFileConstants.F_SCO.equals(mostRestrictiveOccupancyType.getSubtype().getCode())
				|| DxfFileConstants.F_B.equals(mostRestrictiveOccupancyType.getSubtype().getCode())
				|| DxfFileConstants.ITH_R.equals(mostRestrictiveOccupancyType.getSubtype().getCode())
				|| DxfFileConstants.ITH_GH.equals(mostRestrictiveOccupancyType.getSubtype().getCode())
				
				) {
			return BigDecimal.valueOf(0.28);
		}
		else if(DxfFileConstants.F_M.equals(mostRestrictiveOccupancyType.getSubtype().getCode())
				|| DxfFileConstants.F_CFI.equals(mostRestrictiveOccupancyType.getSubtype().getCode())
				|| DxfFileConstants.F_BH.equals(mostRestrictiveOccupancyType.getSubtype().getCode())
				|| DxfFileConstants.ITH_R.equals(mostRestrictiveOccupancyType.getSubtype().getCode())
				|| DxfFileConstants.F_BBM.equals(mostRestrictiveOccupancyType.getSubtype().getCode())
				|| DxfFileConstants.F_TS.equals(mostRestrictiveOccupancyType.getSubtype().getCode())
				|| DxfFileConstants.F_TCIM.equals(mostRestrictiveOccupancyType.getSubtype().getCode())
				|| DxfFileConstants.G_GBZP.equals(mostRestrictiveOccupancyType.getSubtype().getCode())
				|| DxfFileConstants.P_D.equals(mostRestrictiveOccupancyType.getSubtype().getCode())
				|| DxfFileConstants.P_N.equals(mostRestrictiveOccupancyType.getSubtype().getCode())
				|| DxfFileConstants.P_P.equals(mostRestrictiveOccupancyType.getSubtype().getCode())
				|| DxfFileConstants.P_F.equals(mostRestrictiveOccupancyType.getSubtype().getCode())
				|| DxfFileConstants.P_H.equals(mostRestrictiveOccupancyType.getSubtype().getCode())
				|| DxfFileConstants.P_CC.equals(mostRestrictiveOccupancyType.getSubtype().getCode())
				|| DxfFileConstants.P_SS.equals(mostRestrictiveOccupancyType.getSubtype().getCode())
				|| DxfFileConstants.P_CNA.equals(mostRestrictiveOccupancyType.getSubtype().getCode())
				|| DxfFileConstants.P_R.equals(mostRestrictiveOccupancyType.getSubtype().getCode())
				|| DxfFileConstants.B.equals(mostRestrictiveOccupancyType.getType().getCode())
				|| DxfFileConstants.IT.equals(mostRestrictiveOccupancyType.getType().getCode())
				|| DxfFileConstants.ITH_H.equals(mostRestrictiveOccupancyType.getSubtype().getCode())
				|| DxfFileConstants.ITH_C.equals(mostRestrictiveOccupancyType.getSubtype().getCode())
				|| DxfFileConstants.ITH_CC.equals(mostRestrictiveOccupancyType.getSubtype().getCode())
				|| DxfFileConstants.IP.equals(mostRestrictiveOccupancyType.getType().getCode())
				) {
			return BigDecimal.valueOf(0.30);
		}
		else {
			return BigDecimal.valueOf(0.0);
		}
	}

	private void validateNoOfRises(Plan plan, HashMap<String, String> errors, Block block,
			ScrutinyDetail scrutinyDetail3, Floor floor, Map<String, Object> typicalFloorValues,
			org.egov.common.entity.edcr.GeneralStair generalStair, Flight flight, BigDecimal noOfRises) {
		boolean valid = false;

		if (!(Boolean) typicalFloorValues.get("isTypicalRepititiveFloor")) {
			if (Util.roundOffTwoDecimal(noOfRises).compareTo(Util.roundOffTwoDecimal(BigDecimal.valueOf(12))) <= 0) {
				valid = true;
			}

			String value = typicalFloorValues.get("typicalFloors") != null
					? (String) typicalFloorValues.get("typicalFloors")
					: " floor " + floor.getNumber();
			if (valid) {
				setReportOutputDetailsFloorStairWise(plan, CDGAdditionalService.getByLaws(plan, CDGAConstant.STAIRCASE),
						value, String.format(NO_OF_RISER_DESCRIPTION, generalStair.getNumber(), flight.getNumber()),
						EXPECTED_NO_OF_RISER, String.valueOf(noOfRises), Result.Accepted.getResultVal(),
						scrutinyDetail3);
			} else {
				setReportOutputDetailsFloorStairWise(plan, CDGAdditionalService.getByLaws(plan, CDGAConstant.STAIRCASE),
						value, String.format(NO_OF_RISER_DESCRIPTION, generalStair.getNumber(), flight.getNumber()),
						EXPECTED_NO_OF_RISER, String.valueOf(noOfRises), Result.Not_Accepted.getResultVal(),
						scrutinyDetail3);
			}
		}
	}

	/*
	 * private void setReportOutputDetails(Plan pl, String ruleNo, String ruleDesc,
	 * String expected, String actual, String status, ScrutinyDetail scrutinyDetail)
	 * { Map<String, String> details = new HashMap<>(); details.put(RULE_NO,
	 * ruleNo); details.put(DESCRIPTION, ruleDesc); details.put(REQUIRED, expected);
	 * details.put(PROVIDED, actual); details.put(STATUS, status);
	 * scrutinyDetail.getDetail().add(details);
	 * pl.getReportOutput().getScrutinyDetails().add(scrutinyDetail); }
	 */

	private void setReportOutputDetailsFloorStairWise(Plan pl, String ruleNo, String floor, String description,
			String expected, String actual, String status, ScrutinyDetail scrutinyDetail) {
		Map<String, String> details = new HashMap<>();
		details.put(RULE_NO, ruleNo);
		details.put(FLOOR, floor);
		details.put(DESCRIPTION, description);
		details.put(PERMISSIBLE, expected);
		details.put(PROVIDED, actual);
		details.put(STATUS, status);
		scrutinyDetail.getDetail().add(details);
		pl.getReportOutput().getScrutinyDetails().add(scrutinyDetail);
	}

	/*
	 * private void validateDimensions(Plan plan, String blockNo, int floorNo,
	 * String stairNo, List<Measurement> flightPolyLines) { int count = 0; for
	 * (Measurement m : flightPolyLines) { if (m.getInvalidReason() != null &&
	 * m.getInvalidReason().length() > 0) { count++; } } if (count > 0) {
	 * plan.addError(String.format(DxfFileConstants. LAYER_FIRESTAIR_FLIGHT_FLOOR,
	 * blockNo, floorNo, stairNo), count +
	 * " number of flight polyline not having only 4 points in layer " +
	 * String.format(DxfFileConstants.LAYER_FIRESTAIR_FLIGHT_FLOOR, blockNo,
	 * floorNo, stairNo)); } }
	 */

	@Override
	public Map<String, Date> getAmendments() {
		return new LinkedHashMap<>();
	}

}
