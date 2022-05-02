package org.egov.edcr.constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DxfFileConstants {

	public static final String FLUSHING_UNITS_VOLUME_ABOVE_SEVEN_LITRES = "FLUSHING_UNITS_VOLUME_ABOVE_SEVEN_LITRES";

	// CGCL SERVIVE_TYPE
	public static final String RECONSTRUCTION = "Reconstruction";
	public static final String ALTERATION = "Alteration";
	public static final String NEW_CONSTRUCTION = "New Construction";
	public static final String ADDITION_OR_EXTENSION = "Addition or Extension";
	public static final String CHANGE_IN_OCCUPANCY = "Change in occupancy";

	public static final String DATA_NOT_FOUND = "Master data not available";
	public static final String NOT_PERMITTED = "NOT PERMITTED";
	public static final String NOT_PROVIDED = "NOT PROVIDED";
	public static final String NA = "NA";
	// CGCL start according to 26jan

	public static final String PLOT_NO = "PLOT_NUMBER";
	public static final String ZONE = "ZONE";
	public static final String ROOT_BOUNDARY_TYPE = "ROOT_BOUNDARY_TYPE";
	public static final String SECTOR_NUMBER = "SECTOR_NUMBER";
	public static final String PLOT_TYPE = "PLOT_TYPE";
	public static final String KHATA_NO = "KHATA_NO";

	// ROOT_BOUNDARY_TYPE values
	public static final String URBAN = "URBAN";
	public static final String RURAL = "RURAL";

	// DrawingPreference constant
	public static final String DRAWING_PREFERENCE_FEET = "feet";
	public static final String DRAWING_PREFERENCE_METER = "meter";

	// ZONE values
	public static final String CENTER = "CENTER";
	public static final String EAST = "EAST";
	public static final String SOUTH = "SOUTH";

	// PLOT_TYPE values
	public static final String MARLA = "MARLA"; // Till 379.35sqm // low risk
	public static final String ONE_KANAL = "ONE_KANAL"; // 379.35sqm to less than 505.85 sqm //low risk
	public static final String TWO_KANAL = "TWO_KANAL"; // 505.85sqm to less than 1011.7sqm // low risk
	public static final String ABOVE_TWO_KANAL = "ABOVE_TWO_KANAL"; // Above 1011.7sqm // high risk

	// Plan info
	public static final String METER = " m";
	public static final String METER_SQM = " sqm";
	public static final String FEET = "'";
	public static final String INCH = "\"";
	public static final String FEET_SQM = "sqft";

	// Other
	public static final String Hospital_Bedded = "Hospital _Bedded";
	public static final String No_Of_WARD = "No_Of_WARD";
	public static final String IS_BOARDING = "IS_BOARDING";
	public static final String IS_DRINKING_WATER_ON_EACH_FLOOR = "IS_DRINKING_WATER_ON_EACH_FLOOR";
	public static final String YES = "YES";
	public static final String NO = "NO";
	public static final String DAMP_PROOFING_AT_BASEMENT = "DAMP_PROOFING_AT_BASEMENT";
	public static final String COMBUSTIBLE_MATERIAL_IN_FIRE_TOWER = "COMBUSTIBLE_MATERIAL _IN_FIRE_TOWER";
	public static final String EXIT_REQUIREMENT_FIRE_AND_LIFE_SAFETY_AS_PER_NBC = "EXIT_REQUIREMENT_FIRE_&_LIFE_SAFETY_AS_PER_NBC";
	public static final String FIRE_SAFETY_PROVISIONS_AS_PER_NBC_DFPF_FSA = "FIRE_SAFETY_PROVISIONS_AS_PER_NBC_DFPF_FSA";
	public static final String SERVICE_FLOOR_HEIGHT_M = "SERVICE_FLOOR_HEIGHT_M";
	public static final String BASEMENT_SERVICES_PRINTING_PRESS_A_C_PLANTS_ELECTRICAL_PANELS_FILTRATIONPLANTS_LAUNDRYPLANTS_OR_MACHINES_AUTOMATED_STACK_PARKING = "BASEMENT_SERVICES_PRINTING PRESS_A.C. PLANTS_ELECTRICAL PANELS_FILTRATIONPLANTS_LAUNDRYPLANTS_OR_MACHINES_ AUTOMATED/STACK PARKING";
	public static final String SOLAR_PHOTOVOLTAIC_KWP = "SOLAR_PHOTOVOLTAIC_KWP";
	public static final String WHETHER_STAIRCASE_TOUCHING_LIFT_SHAFT = "WHETHER_STAIRCASE_TOUCHING_LIFT_SHAFT";
	public static final String SOIL_OR_VENTILATING_PIPE_EXTERNAL_WALL = "SOIL_OR_VENTILATING_PIPE_EXTERNAL_WALL";
	public static final String ARTIFICIAL_AND_MECHANICAL_VENTILATION_PROVIDED = "ARTIFICIAL_AND_MECHANICAL_VENTILATION_PROVIDED";
	public static final String EXISTING_BUILDING_CONSTRUCTED_WITHOUT_BASEMENT = "EXISTING_BUILDING_CONSTRUCTED_WITHOUT_BASEMENT";
	public static final String TOTAL_USERS = "TOTAL_USERS";
	public static final String HOSPITAL_TYPE = "HOSPITAL_TYPE";
	public static final String SOLOR_WATER_HEATING_IN_LTR = "SOLOR_WATER_HEATING_IN_LTR";
	public static final String RESIDENTIAL_NO_OWNER = "RESIDENTIAL_NO_OWNER";
	
	
	//OC fee calculation
	public static final String IS_THIS_A_CASE_OF_OWNERSHIP_CHANGE = "IS_THIS_A_CASE_OF_OWNERSHIP CHANGE";
	public static final String IS_DPC_CERTIFICATE_AVAILABLE = "IS_DPC_CERTIFICATE_AVAILABLE";
	public static final String NUMBER_OF_FLOORS_WITH_CHANGES_IN_DOORS_OR_WINDOWS_LOCATIONS = "NUMBER_OF_FLOORS_WITH_CHANGES_IN_DOORS_OR_WINDOWS_LOCATIONS";
	public static final String NUMBER_OF_GLAZING_IN_VERANDAH = "NUMBER_OF_GLAZING_IN_VERANDAH";
	public static final String NUMBER_OF_LOFTS_CONSTRUCTED_BEYOND_PERMIT = "NUMBER_OF_LOFTS_CONSTRUCTED_BEYOND_PERMIT";
	public static final String NUMBER_OF_NON_STANDARD_GATES = "NUMBER_OF_NON_STANDARD_GATES";
	public static final String NUMBER_OF_NICHES_ON_THE_COMMON_WALL = "NUMBER_OF_NICHES_ON_THE_COMMON_WALL";
	public static final String AREA_OF_FALSE_CEILING = "AREA_OF_FALSE_CEILING";
	

	public static final String HOSPITAL_GOVERNMENT = "Government";
	public static final String HOSPITAL_PRIVATE = "Private";
	public static final String ARCHITCTURE_CONTROLS_APPLICABLE = "ARCHITCTURE_CONTROLS_APPLICABLE";
	public static final String JOB_NUMBER = "JOB_NUMBER";
	public static final String DWG_NUMBER = "DWG_NUMBER";

	public static final String ULBNAME = "Chandigarh Administration";

	public static final String OPTIONAL = "Optional";

	// Rural plan info
	public static final String LOCATION = "LOCATION";
	public static final String PLOT_LENGTH = "PLOT_LENGTH";
	public static final String PLOT_WIDTH = "PLOT_WIDTH";
	public static final String COMMERCIAL_AREA_OCCUPANCY_AS_PER_RULE = "COMMERCIAL_AREA_OCCUPANCY_AS_PER_RULE";

	// CGCL start
	// occupancies code
	public static final String A = "A"; // Residential --29
	public static final String F = "F"; // Mercantile / Commercial
	public static final String G = "G"; // Industrial
	public static final String P = "P"; // Public / Semi- Public Buildings
	public static final String B = "B"; // Educational
	public static final String IT = "IT";// IT Park
	public static final String R = "R";// Railway Station, Chandigarh --np
	public static final String ITH = "ITH";// IT Habitat --np
	public static final String IP = "IP";// Integrated projects --np
	public static final String T = "T";// Transit Oriented Development (TOD) --np

	// sub occupancies code
	public static final String A_P = "A-P";// Plotted --220
	public static final String A_G = "A-G";// Grouped --223

	public static final String F_CIR = "F-CIR";// commercial in rural

	public static final String A_SQ = "A-SQ";// Servant quarter
	public static final String A_PO = "A-PO";// Professional Office
	public static final String A_S = "A-S";// STD/ PCO/ fax and photostat machine
	public static final String A_PG = "A-PG";// Creche and paying guest facility
	public static final String A_EWS = "A-EWS";// EWS
	public static final String A_ICP = "A-ICP"; // In Checkpost
	public static final String A_OCP = "A-OCP"; // Out Checkpost
	public static final String IT_AF = "IT-AF";// Ancillary Facilities
	public static final String A_GF = "A-GF";// Gallery floor;
	public static final String A_RU = "A-RU";// Residential use ;
	public static final String A_CC = "A-CC";// Community Facilities In Group Housing Building
	public static final String A_AF = "A-AF";// Additional Fee
	public static final String A_R5 = "A-R5";// Additional Fee

	public static final String F_SCO = "F-SCO";// SCO'S/ SCF'S / BAYSHOP'S/ SEMI INDUSTRIAL -- 272
	public static final String F_B = "F-B"; // BOOTHS ETC.
	public static final String F_H = "F-H";// Hotels -- 236
	public static final String F_M = "F-M";// MULTIPLEX/MALLS (specifically earmarked sites) -- 278
	public static final String F_CFI = "F-CFI";// COMMERCIAL (converted from Industrial) --237
	public static final String F_BH = "F-BH";// Banquet hall/ marriage palaces -- 271
	public static final String F_BBM = "F-BBM";// Bulk building material -- 279
	public static final String F_TS = "F-TS";// Timber site (single storey) -- 280
	public static final String F_TCIM = "F-TCIM";// Comercial_Theatre converted into multiplex -- 270
	public static final String F_PP = "F-PP"; // Petrol Pump -- 234
	public static final String F_CD = "F-CD"; // Coal Depot

	public static final String G_GBAC = "G-GBAC";// Governed by Architectural Controls //CHANGED //245
	public static final String G_GBZP = "G-GBZP";// Governed by Zoning Plans //14

	public static final String P_D = "P-D"; // Dispensary
	public static final String P_P = "P-P";// Police Station
	public static final String P_F = "P-F"; // Fire Station
	public static final String P_N = "P-N"; // Nursing Home
	public static final String P_H = "P-H";// Hospital
	public static final String P_CC = "P-CC";// Community centre/Janj Ghar
	public static final String P_SS = "P-SS";// Sports Stadium
	public static final String P_CNA = "P-CNA";// Cultural and Non Academic institutional sites
	public static final String P_R = "P-R";// Religious

	public static final String B_EC = "B-EC";// Education city (Sarangpur)
	public static final String B_HEI = "B-HEI";// Higher Educational Institute //Educational/ Academic
	public static final String B_H = "B-H";// Hostels

	public static final String IT_MCL = "IT-MCL";// Main Campus (above 6 acre)
	public static final String IT_MCM = "IT-MCM";// Small Campus (2 to 6 acre)
	public static final String IT_MCS = "IT-MCS";// built to suite site (2 acre or below)

	public static final String R1 = "R1"; // Railway Station, Chandigarh

	public static final String ITH_H = "ITH-H";// Hospital //CHANGED
	public static final String ITH_C = "ITH-C";// COMMERCIAL / HOTEL
	public static final String ITH_CC = "ITH-CC";// Club
	public static final String ITH_R = "ITH-R";// RESIDENTIAL
	public static final String ITH_GH = "ITH-GH";// Government housing
	public static final String IP_I = "IP-I";// Institutional (70%)
	public static final String IP_R = "IP-R";// Residential (25%)
	public static final String IP_C = "IP-C";// Commercial (5%)

	public static final String T1 = "T1";// Transit Oriented Development (TOD)

	// OC buildup area
	public static final String OC = "OC";// Occupancy Certificate
	public static final String OC_MIC = "OC-MIC";// Minor Internal Changes
	public static final String OC_GOV = "OC-GOV";// Glazing Of Verandah

	// CGCL end

	public static final String C = "C"; // Medical/Hospital
	public static final String D = "D"; // Assembly
	public static final String E = "E"; // Office/Business
	public static final String H = "H"; // Storage
	public static final String I = "I"; // Hazardous

	public static final String A2 = "A2";// Old Age Home
	public static final String A_R = "A-R"; // Single family Residential
	// public static final String A_AF = "A-AF"; // Apartment/Flat
	public static final String A_FH = "A-FH"; // Farm House
	public static final String A_SR = "A-SR";// Special Residential
	public static final String A_HE = "A-HE";// Hostel Educational
	public static final String A_SA = "A-SA";// Service Apartment

	public static final String A_AF_GH = "A-AF-GH";

	public static final String F_K = "F-K";// Kiosk
	public static final String F_PA = "F-PA";// Parking Appurtenant
	// public static final String F_PP = "F-PP";// Parking Plaza
	public static final String F_RT = "F-RT";// Restaurants
	public static final String F_LD = "F-LD";// Lodges
	public static final String F_CB = "F-CB";// Commercial Building
	public static final String F_IT = "F-IT";// IT / ITES Buildings

	public static final String G_LI = "G-LI";// Large Industrial
	public static final String G_SI = "G-SI";// Small Industrial
	public static final String G_PHI = "G-PHI";// Polluting and hazardous industries
	public static final String G_NPHI = "G-NPHI";// Non-polluting and household industries

	// CGCL start according to 26jan

	public static final String A_G_E = "A-G-E";// Grouped EWS

	// CGCL end according to 26jan

	public static final String PLOT_TYPE_NOT_DEFINED = "Plot Type is not defined in Plan info";

	// CGCL start according to 26jan

	// CGCL end according to 26jan

	public static final String B2 = "B2";// Educational HighSchool
	public static final String B_PS = "B-PS";// Primary school

	public static final String C_MA = "C-MA";// Medical Admin
	public static final String C_MIP = "C-MIP";// Medical IP
	public static final String C_MOP = "C-MOP";// Medical OP

	public static final String D_B = "D-B"; // At sub city level in urban extension
	public static final String D_C = "D-C"; // Anganwari
	public static final String D_A = "D-A"; // Religious
	public static final String D_AW = "D-AW";// Assembly Worship
	public static final String D_BT = "D-BT";// Bus Terminal

	public static final String E_PS = "E-PS";// Primary School
	public static final String E_SFMC = "E-SFMC";// School for Mentally Challenged
	public static final String E_SFDAP = "E-SFDAP";// School for differently abled persons
	public static final String E_EARC = "E-EARC";// Academic, including administration
	public static final String E_NS = "E-NS";// Nursury Schools
	public static final String E_CLG = "E-CLG";// College
	public static final String E_SACA = "E-SACA";// Sports and Cultural Activities

	// change raza end

	public static final String H_PP = "H-PP"; // Petrol Pump

	public static final String I1 = "I-1";// Hazardous (I1)
	public static final String I2 = "I-2";// Hazardous (I2)

	public static final String M_DFPAB = "M-DFPAB";// Dispensary for pet animals and birds
	public static final String M_OHF = "M-OHF";// Other Health Facilities
	public static final String M_VH = "M-VH";// Veterinary Hospital for pet animals and birds
	public static final String M_NAPI = "M-NAPI";// Nursing and Paramedic Institute
	public static final String M_HOTHC = "M-HOTHC";// Hospital/Teritary Health care Centre

	public static final String S_MCH = "S-MCH";// Multipurpose Community Hall
	public static final String S_BH = "S-BH";// Banquet hall
	public static final String S_CRC = "S-CRC";// Community Recreational Club
	public static final String S_CA = "S-CA";// Cultural activities
	public static final String S_SC = "S-SC";// Science centre
	public static final String S_ECFG = "S-ECFG"; // Exhibition cum Fair Ground
	public static final String S_SAS = "S-SAS"; // Sports and amenity structures
	public static final String S_ICC = "S-ICC";// International Convention Centre

	public static final String VERT_CLEAR_OHE = "VERT_CLEAR_OHEL";
	public static final String REAR_YARD = "REAR_YARD";
	public static final String BUILDING_FOOT_PRINT = "BLDG_FOOT_PRINT";
	public static final String SIDE_YARD_2 = "SIDE_YARD2";
	public static final String SIDE_YARD_1 = "SIDE_YARD1";
	public static final String FRONT_YARD = "FRONT_YARD";
	public static final String NOTIFIED_ROADS = "NOTIFIED_ROAD";
	public static final String NON_NOTIFIED_ROAD = "NON_NOTIFIED_ROAD";
	public static final String CULD_1 = "CULD_1";
	public static final String LANE_1 = "LANE_1";
	public static final String HORIZ_CLEAR_OHE2 = "HORIZ_CLEAR_OHEL";
	public static final String PLOT_BOUNDARY = "PLOT_BOUNDARY";
	public static final String LAYER_EXIT_WIDTH_DOOR = "BLK_%s_FLR_%s_EXIT_WIDTH_DOOR";
	public static final String LAYER_EXIT_WIDTH_STAIR = "BLK_%s_FLR_%s_EXIT_WIDTH_STAIR";
	public static final String LAYER_OHEL = "OHEL";
	public static final String LAYER_BIOMETRIC_WASTE_TREATMENT = "BIOMETRIC_WASTE_MNGMNT";
	public static final String LAYER_MEZZANINE_FLOOR_BLT_UP_AREA = "BLK_%s_FLR_%s_M_%s_BLT_UP_AREA";
	public static final String LAYER_MEZZANINE_FLOOR_DEDUCTION = "BLK_%s_FLR_%s_M_%s_BLT_UP_AREA_DEDUCT";
	public static final String LAYER_MEZZANINE_HALL_BLT_UP_AREA = "BLK_%s_FLR_%s_HALL_%s_BLT_UP_AREA";
	public static final String LAYER_MEZZANINE_HALL_DEDUCTION = "BLK_%s_FLR_%s_HALL_%s_BLT_UP_AREA_DEDUCT";
	public static final String LAYER_HGHT_ROOM = "BLK_%s_FLR_%s_HT_ROOM";
	public static final String LAYER_TRAVEL_DIST_TO_EXIT = "DIST_EXIT";
	public static final String LAYER_DA_RAMP = "BLK_%s_DA_RAMP";
	public static final String LAYER_DA_ROOM = "BLK_%s_FLR_%s_DA_ROOM";
	public static final String LAYER_LIFT = "BLK_%s_FLR_%s_LIFT";
	public static final String LAYER_DEPTH_CUTTING = "DEPTH_CUTTING";
	public static final String LAYER_ACCESSORY_BUILDING = "ACCBLK";
	public static final String DEPTH_CUTTING = "DEPTH_CUTTING_MORE_THAN_1.5_M";
	public static final String LAYER_RAMP = "BLK_%s_FLR_%s_RAMP";
	public static final String LAYER_ACCESSORY_SHORTEST_DISTANCE = "ACC_SHORTEST_DIST_TO_ROAD";
	public static final String LAYER_ACCESSORY_DIST_TO_PLOT_BNDRY = "ACCBLK_%s_DIST_BOUNDARY";
	public static final String LAYER_EXISTING_BLT_UP_AREA_DEDUCT = "BLK_%s_FLR_%s_BLT_UP_AREA_DEDUCT_EXISTING";
	public static final String LAYER_CANOPY = "DIST_CANOPY";
	public static final String FLOOR_HEIGHT_PREFIX = "FLOOR_HEIGHT";
	public static final String GOVERNMENT_AIDED = "WHETHER_GOVT_OR_AIDED_SCHOOL";
	public static final String LAYER_RAMP_WITH_NO = "BLK_%s_FLR_%s_RAMP_%s";
	public static final String LAYER_VEHICLE_RAMP_WITH_NO = "BLK_%s_FLR_%s_VEHICLE_RAMP_%s";
	public static final String LAYER_LIFT_WITH_NO = "BLK_%s_FLR_%s_LIFT_%s";
	public static final String LAYER_PLINTH_HEIGHT = "BLK_%s_PLINTH_HEIGHT";

	public static String CRZ_ZONE = "CRZ";
	public static final String PLOT_AREA = "PLOT_AREA_M2";
	public static final Object ARCHITECT_NAME = "ARCHITECT_NAME";
	public static final String SHORTEST_DISTANCE_TO_ROAD = "SHORTEST_DIST_TO_ROAD";
	public static final String PLAN_INFO = "PLAN_INFO";
	public static String LAYER_NAME_WASTE_DISPOSAL = "WASTE_DISPOSAL";
	public static final String LAYER_NAME_WATER_CLOSET = "WATER_CLOSET";
	public static final String LAYER_NAME_URINAL = "URINAL";
	public static final String LAYER_NAME_WASH = "WASH";
	public static final String LAYER_NAME_BATH = "BATH";
	public static final String LAYER_NAME_WC_BATH = "WC_BATH";
	public static final String LAYER_NAME_DRINKING_WATER = "DRINKING_WATER";
	public static final String LAYER_NAME_SPECIAL_WATER_CLOSET = "SP_WC";
	public static final String LAYER_FIRESTAIR_FLOOR = "BLK_%s_FLR_%s_FIRESTAIR_%s";
	public static final String LAYER_FLOOR_BLT_UP = "BLK_%s_FLR_%s_BLT_UP_AREA";
	public static final String LAYER_FLOOR_SPIRAL_STAIR = "BLK_%s_FLR_%s_SPIRAL_FIRE_STAIR_%s";
	public static final String LAYER_FIRESTAIR_FLIGHT = "BLK_%s_FLR_%s_FIRESTAIR_%s_FLIGHT_%s";
	public static final String FLOOR_HEIGHT = "FLR_HT_M";
	public static final String LAYER_COVERAGE = "BLK_%s_COVERED_AREA";
	public static final String LAYER_COVERAGE_DEDUCT = "BLK_%s_COVERED_AREA_DEDUCT";

	public static final String LAYER_STAIR_FLOOR = "BLK_%s_FLR_%s_STAIR_%s";
	public static final String LAYER_STAIR_FLIGHT = "BLK_%s_FLR_%s_STAIR_%s_FLIGHT_%s";

	public static final String ACCESS_WIDTH = "ACCESS_WIDTH_M";
	public static final String HEIGHT_OF_BUILDING = "HT_OF_BLDG";
	public static final String BUILT_UP_AREA = "BLT_UP_AREA";
	public static final int BLDG_EXTERIOR_WALL_COLOR = 2;
	public static final String FAR_DEDUCT = "FAR_DEDUCT";
	public static final int FAR_DEDUCT_COLOR = 2;
	public static final String COVERGAE_DEDUCT = "COVERAGE_DEDUCT"; // not used
																	// in PHASE2
	public static final String BUILT_UP_AREA_DEDUCT = "BLT_UP_AREA_DEDUCT";
	public static final String SECURITY_ZONE = "SECURITY_ZONE";
	public static final String FLOOR_AREA = "FLOOR_AREA";
	public static final String OCCUPANCY = "OCCUPANCY";
	public static final String FLOOR_NAME_PREFIX = "FLR_";
	public static final String BLOCK_NAME_PREFIX = "BLK_";
	public static final String EXISTING_PREFIX = "_EXISTING";
	public static final String LEVEL_NAME_PREFIX = "LVL_";
	public static final int HABITABLE_ROOM_COLOR = 4;
	public static final int FLOOR_EXTERIOR_WALL_COLOR = 5;
	public static final int FLOOR_OPENSPACE_COLOR = 6;
	public static final String SHADE_OVERHANG = "SHADE_OVERHANG";
	public static final String OPEN_STAIR = "OPEN_STAIR";
	public static final String DIST_CL_ROAD = "DIST_CL_ROAD";
	public static final String OPENING_BELOW_2_1_ON_SIDE_LESS_1M = "OPENING_BELOW_2.1_ON_SIDE_LESS_1M_OR_LESS_EQUALTO_0.6M";
	public static final String OPENING_BELOW_2_1_ON_REAR_LESS_1M = "OPENING_BELOW_2.1_ON_REAR_LESS_1M";
	public static final String OPENING_ABOVE_2_1_ON_SIDE_LESS_1M = "OPENING_ABOVE_2.1_ON_SIDE_LESS_1M_OR_LESS_EQUALTO_0.6M";
	public static final String OPENING_ABOVE_2_1_ON_REAR_LESS_1M = "OPENING_ABOVE_2.1_ON_REAR_LESS_1M";

	public static final String NOC_TO_ABUT_SIDE = "NOC_TO_ABUT_SIDE";
	public static final String NOC_TO_ABUT_REAR = "NOC_TO_REAR_SIDE";
	public static final String MAX_HEIGHT_CAL = "MAX_HEIGHT_CAL";
	public static final String BSMNT_REAR_YARD = "BSMNT_REAR_YARD";
	public static final String BSMNT_FOOT_PRINT = "BSMNT_FOOT_PRINT";
	public static final String BSMNT_SIDE_YARD_1 = "BSMNT_SIDE_YARD_1";
	public static final String BSMNT_SIDE_YARD_2 = "BSMNT_SIDE_YARD_2";
	public static final String BSMNT_FRONT_YARD = "BSMNT_FRONT_YARD";
	public static final String RESI_UNIT = "RESI_UNIT";
	public static final String RESI_UNIT_DEDUCT = "RESI_UNIT_DEDUCT";
	public static final String PARKING_SLOT = "PARKING_SLOT";
	public static final String UNITFA = "UNITFA";
	public static final String UNITFA_DEDUCT = "UNITFA_DEDUCT";
	public static final String UNITFA_HALL = "UNITFA_HALL";
	public static final String UNITFA_BALCONY = "UNITFA_BALCONY";
	public static final String UNITFA_DINING = "UNITFA_DINING";
	public static final String TWO_WHEELER_PARKING = "TWO_WHEELER_PARKING";
	public static final String LOADING_UNLOADING = "LOADING_UNLOADING";
	public static final String MECHANICAL_PARKING = "MECHANICAL_PARKING";
	public static final String MECH_PARKING = "MECH_PARKING";
	public static final String DA_PARKING = "DA_PARKING";
	public static final String SINGLE_FAMILY_BLDG = "SINGLE_FAMILY_BLDG";
	public static final String SEATS_SP_RESI = "SEATS_SP_RESI";
	public static final String LAYER_NAME_DIST_BETWEEN_BLOCKS = "DIST_BETWEEN_BLK_%s_BLK_%s";
	public static final int COLOUR_CODE_NOTIFIEDROAD = 1;
	public static final int COLOUR_CODE_NONNOTIFIEDROAD = 2;
	public static final int COLOUR_CODE_LANE = 5;
	public static final int COLOUR_CODE_CULDESAC = 6;
	public static final int COLOUR_CODE_WELLTOBOUNDARY = 7;
	public static final int COLOUR_CODE_WELLTOLEACHPIT = 8;
	public static final Integer COLOUR_CODE_LEACHPIT_TO_PLOT_BNDRY = 9;
	public static final int OCCUPANCY_A1_COLOR_CODE = 25;
	public static final int OCCUPANCY_A2_COLOR_CODE = 3;
	public static final int OCCUPANCY_B1_COLOR_CODE = 4;
	public static final int OCCUPANCY_B2_COLOR_CODE = 14;
	public static final int OCCUPANCY_B3_COLOR_CODE = 15;
	// public static final int OCCUPANCY_C_COLOR_CODE = 5;
	public static final int OCCUPANCY_D_COLOR_CODE = 6;
	public static final int OCCUPANCY_E_COLOR_CODE = 7;
	public static final int OCCUPANCY_F_COLOR_CODE = 8;
	public static final int OCCUPANCY_G1_COLOR_CODE = 9;
	public static final int OCCUPANCY_G2_COLOR_CODE = 10;
	public static final int OCCUPANCY_H_COLOR_CODE = 11;
	public static final int OCCUPANCY_I1_COLOR_CODE = 12;
	public static final int OCCUPANCY_I2_COLOR_CODE = 13;
	public static final int OCCUPANCY_D1_COLOR_CODE = 16;
	public static final int OCCUPANCY_A2_BOARDING_COLOR_CODE = 19;
	public static final int OCCUPANCY_C1_COLOR_CODE = 5;
	public static final int OCCUPANCY_C2_COLOR_CODE = 20;
	public static final int OCCUPANCY_C3_COLOR_CODE = 21;
	public static final int OCCUPANCY_D2_COLOR_CODE = 22;
	public static final int OCCUPANCY_F1_COLOR_CODE = 17;
	public static final int OCCUPANCY_F2_COLOR_CODE = 18;
	public static final int OCCUPANCY_F3_HOTEL_COLOR_CODE = 23;
	public static final int OCCUPANCY_A1_APARTMENT_COLOR_CODE = 2;
	public static final int OCCUPANCY_A1_PROFESSIONALOFFICE_COLOR_CODE = 24;
	public static final int OCCUPANCY_I2_KIOSK_COLOR_CODE = 26;

	public static final int MEZZANINE_HEAD_ROOM_COLOR_CODE = 1;
	public static final int NORMAL_ROOM_BCEFHI_OCCUPANCIES_COLOR_CODE = 2;
	public static final int AC_ROOM_BCEFHI_OCCUPANCIES_COLOR_CODE = 3;
	public static final int CAR_AND_TWO_WHEELER_PARKING_ROOM_COLOR_CODE = 4;
	public static final int ASSEMBLY_ROOM_COLOR_CODE = 5;
	public static final int ASSEMBLY_AC_HALL_COLOR_CODE = 6;
	public static final int HEAD_ROOM_BENEATH_OR_ABOVE_BALCONY_COLOR_CODE = 7;
	public static final int HEAD_ROOM_IN_GENERAL_AC_ROOM_IN_ASSEMBLY_OCCUPANCY_COLOR_CODE = 8;
	public static final int GENERALAC_STORE_TOILET_LAMBER_CELLAR_ROOM_COLOR_CODE = 9;
	public static final int WORK_ROOM_UNDER_OCCUPANCY_G_COLOR_CODE = 10;
	public static final int LAB_ENTRANCE_HALL_CANTEEN_CLOAK_ROOM_COLOR_CODE = 11;
	public static final int STORE_TOILET_ROOM_IN_INDUSTRIES_COLOR_CODE = 12;

	public static final int OCCUPANCY_A2_PARKING_WITHATTACHBATH_COLOR_CODE = 3;
	public static final int OCCUPANCY_A2_PARKING_WOATTACHBATH_COLOR_CODE = 23;
	public static final int OCCUPANCY_A2_PARKING_WITHDINE_COLOR_CODE = 24;

	// ***********START - Extra functionalities color code key names************
	// ******** Height of room related ************
	public static final String COLOR_KEY_MEZZANINE_HEAD_ROOM = "Mezzanine head room";
	public static final String COLOR_KEY_NORMAL_ROOM_BCEFHI_OCCUPANCIES = "Normal room for BCEFHI occupancies";
	public static final String COLOR_KEY_AC_ROOM_BCEFHI_OCCUPANCIES = "AC room for BCEFHI occupancies";
	public static final String COLOR_KEY_CAR_AND_TWO_WHEELER_PARKING_ROOM = "Car and two parking room";
	public static final String COLOR_KEY_ASSEMBLY_ROOM = "Assembly room";
	public static final String COLOR_KEY_ASSEMBLY_AC_HALL = "Assembly AC hall";
	public static final String COLOR_KEY_HEAD_ROOM_BENEATH_OR_ABOVE_BALCONY = "Head room beneath or above balcony";
	public static final String COLOR_KEY_HEAD_ROOM_IN_GENERAL_AC_ROOM_IN_ASSEMBLY_OCCUPANCY = "Head room in general AC room in assembly";
	public static final String COLOR_KEY_GENERALAC_STORE_TOILET_LAMBER_CELLAR_ROOM = "GeneralLac store toiler lambar cellar";
	public static final String COLOR_KEY_WORK_ROOM_UNDER_OCCUPANCY_G = "Work room under industrial";
	public static final String COLOR_KEY_LAB_ENTRANCE_HALL_CANTEEN_CLOAK_ROOM = "Lab entrance hall canteen cloak room";
	public static final String COLOR_KEY_STORE_TOILET_ROOM_IN_INDUSTRIES = "Store toilet room in industrial";
	public static final String COLOR_RESIDENTIAL_ROOM = "Residential room";
	public static final String COLOR_COMMERCIAL_ROOM = "Commercial room";
	public static final String COLOR_EDUCATIONAL_ROOM = "Educational room";
	public static final String COLOR_INDUSTRIAL_ROOM = "Industrial room";
	public static final String RESIDENTIAL_KITCHEN_ROOM_COLOR = "Residential kitchen room";
	public static final String RESIDENTIAL_KITCHEN_STORE_ROOM_COLOR = "Residential kitchen store room";
	public static final String RESIDENTIAL_KITCHEN_DINING_ROOM_COLOR = "Residential kitchen dining room";
	public static final String COMMERCIAL_KITCHEN_ROOM_COLOR = "Commercial kitchen room";
	public static final String COMMERCIAL_KITCHEN_STORE_ROOM_COLOR = "Commercial kitchen store room";
	public static final String COMMERCIAL_KITCHEN_DINING_ROOM_COLOR = "Commercial kitchen dining room";
	// ******** Sanitation related ************
	public static final String COLOR_KEY_MALE_WATER_CLOSET = "Male water closet";
	public static final String COLOR_KEY_FEMALE_WATER_CLOSET = "Female water closet";
	public static final String COLOR_KEY_COMMON_WATER_CLOSET = "Common water closet";

	// Yard related
	public static final String COLOR_KEY_YARD_DIMENSION = "Yard dimension";

	// ********Parking related************
	public static final String COLOR_KEY_A_SR_PARKING_WITHATTACHBATH = "Special residetial with attach bath";
	public static final String COLOR_KEY_A_SR_PARKING_WOATTACHBATH = "Special residetial without attach bath";
	public static final String COLOR_KEY_A_SR_PARKING_WITHDINE = "Special residetial with dine";

	// *******Stair related**************
	public static final String COLOR_KEY_FLIGHT_LENGTH = "Flight length";
	public static final String COLOR_KEY_FLIGHT_WIDTH = "Flight width";

	// ********Interior open space related*****
	public static final String COLOR_KEY_HABITABLE_ROOM = "Habitable room";
	public static final String COLOR_KEY_FLR_EXTERIOR_WALL = "Floor exterior wall";
	public static final String COLOR_KEY_FLR_OPEN_SPACE = "Floor open space";

	// ********Distances related*****
	public static final String COLOR_KEY_NOTIFIED_ROAD = "Notified road";
	public static final String COLOR_KEY_NON_NOTIFIED_ROAD = "Non notified road";
	public static final String COLOR_KEY_LANE = "lane";
	public static final String COLOR_KEY_CULDE_SAC_ROAD = "Culdesac road";
	public static final String COLOR_KEY_WELL_TO_BNDRY = "Well to boundary";
	public static final String COLOR_KEY_WELL_TO_LEACH_PIT = "Well to leach pit";
	public static final String COLOR_KEY_PIT_TO_PLOT_BNDRY = "Leach pit to plot boundary";
	// ***********END - Extra functionalities color code key names************

	public static final String MTEXT_NAME_HEIGHT_M = "HEIGHT_M";
	public static final int COLOR_CODE_MALE_WATER_CLOSET = 1;
	public static final int COLOR_CODE_FEMALE_WATER_CLOSET = 2;
	public static final int COLOR_CODE_COMMON_WATER_CLOSET = 3;
	public static final String LAYER_NAME_MAX_HEIGHT_CAL = "BLK_%s_MAX_HEIGHT_CAL";
	public static final String LAYER_NAME_MAX_HEIGHT_CAL_SET_BACK = "BLK_%s_MAX_HEIGHT_CAL_SET_BACK";
	public static final String INSITU_WASTE_TREATMENT_PLANT = "INSITU_WASTE_TREATMENT_PLANT";
	public static final String RECYCLING_WASTE_WATER = "RECYCLING_WASTE_WATER";
	public static final String LAYER_NAME_WELL = "WELL";
	public static final String DIST_WELL = "DIST_WELL";
	public static final String RAINWATER_HARWESTING = "RWH";
	public static final String SOLAR = "SOLAR";
	public static final String RWH_CAPACITY_L = "RWH_CAPACITY_L";
	public static final String SOLID_LIQUID_WASTE_TREATMENT = "SOLID_LIQUID_WASTE_TREATMENT";
	public static final String EXISTING_FLOOR_AREA_TO_BE_DEMOLISHED = "EXISTING_FLOOR_AREA_TO_BE_DEMOLISHED_M2";

	public static final String RESURVEY_NO = "RS_NO";
	public static final String REVENUE_WARD = "REVENUE_WARD";
	public static final String VILLAGE = "VILLAGE";
	public static final String DESAM = "DESAM";
	public static final Object NO_OF_BEDS = "NO_OF_BEDS";
	public static final int YARD_DIMENSION_COLOR = 2;

	public static final String AREA_TYPE = "Area Type";
	// public static final String ROAD_WIDTH = "Road Width";
	public static final String COMMERCIAL = "COMMERCIAL";
	public static final String RULE_28 = "28";
	public static final String SETBACK = "SetBack";
	public static final String YARD_NAME = "Yard Name";

	public static final String OCCUPANCY_ALLOWED = "Only residential or commerical or industrial buildings will be scrutinized for now.";
	public static final String OCCUPANCY_ALLOWED_KEY = "occupancy_allowed";
	public static final String OCCUPANCY_PO_NOT_ALLOWED = "Plans with only professional office occupancy is not allowed";
	public static final String OCCUPANCY_PO_NOT_ALLOWED_KEY = "occupancy_po_not_allowed";
	public static final String RWH_DECLARED = "RWH_DECLARED";

	public static final String ANONYMOUS_APPLICANT = "ANONYMOUS";
	public static final String NEWCONSTRUCTION_SERVICE = "New Construction";
	public static final String MAINRIVER = "MainRiver";
	public static final String SUBRIVER = "SubRiver";

	// dimensioning message
	public static final String MESSAGE_FEET = "All provided values are in feets and Sq ft.";
	public static final String MESSAGE_METER = "All provided values are in meters and Sq m.";

	public static final String LITTERS = "litres";

	public static final String BLT_UP_AREA_ERROR_MSG = "Please cross verify *_BLT_UP_AREA layer";
	public static final String RURAL_ULB_NAME = "Chandigarh Municipal Corporation";

	public static final String DECLARATION_METER = "All dimensions are in metre or square metre.";
	public static final String DECLARATION_FEET = "All dimensions are in feet or square feet.";

	public static final String KEY_METER_ENABLE = "dcr.meter.enabled";
	public static final String KEY_FEET_ENABLE = "dcr.feet.enabled";

	public static final String ROAD_WIDTH = "ROAD_WIDTH";
	public static final String ROAD_LENGTH = "ROAD_LENGTH";
	public static final String ROAD_2_WIDTH = "ROAD_2_WIDTH";
	public static final String ROAD_2_LENGTH = "ROAD_2_LENGTH";

	public static final String CONVERSION_CHARGES_AREA = "CONVERSION_CHARGES_AREA";
	public static final String DEMOLITION_AREA = "DEMOLITION_AREA";

	public static final String ALLOTMENT_OF_NEW_NUMBER = "ALLOTMENT_OF_NEW_NUMBER";

	public static final String IS_CASE_OF_DEATH = "IS_CASE_OF_DEATH";

	// ApplicationType
	public static final String APPLICATION_TYPE_PERMIT = "PERMIT";
	public static final String APPLICATION_TYPE_OCCUPANCY_CERTIFICATE = "OCCUPANCY_CERTIFICATE";
	public static final String EXCESS_COVERAGE_6_INCH_BEYOND_BUILD_UP_AREA = "EXCESS_COVERAGE_6_INCH_BEYOND_BUILD_UP_AREA";
	public static final String MULTI_BAY_PARTITIONS_NUMBER = "MULTI_BAY_PARTITIONS_NUMBER";

	public static final String PLAN_INFO_STAIR_COVERS_AREA = "BLOCK_%s_STAIR_COVERS_AREA";

	public static final String TRANSFER_FEE_APPLICABLE = "TRANSFER_FEE_APPLICABLE";

	public static final String PRESENT_COLLECTOR_RATE = "PRESENT_COLLECTOR_RATE";
	public static final String AREA_FOR_ADDITIONAL_HEIGHT_SQFT = "AREA_FOR_ADDITIONAL_HEIGHT_SQFT";

	public static final String RULE_5_APPLICABLE = "RULE_5_APPLICABLE";

	public static final List<String> IS_FEATURE = Arrays.asList(new String[] { "A-R5", "A-GF", "A-OCP", "A-ICP", "A-AF",
			"A-PO", "A-PG", "A-S", "A-SQ", "OC-MIC", "OC-GOV"});
}
