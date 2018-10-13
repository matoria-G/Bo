package com.bo.file.constants;

public class FileConstants {
	
	//Common Key Codes

	public static final String RECORD_COUNT = "RECORD_COUNT";
	
	public static final String ENTITY_NUM = "ENTITY_NUM";
	public static final String UPLD_DATE = "UPLD_DATE";
	public static final String UPLD_DAY_SL = "DAY_SL";
	public static final String RESULT = "RESULT";
	public static final String ERROR = "ERROR";
	public static final String ERROR_DAY_SL = "ERROR_DAY_SL";	
	public static final String UPLD_REF = "UPLD_REF";
	public static final String CMUPLD_SL = "CMUPLD_SL";
	public static final String ENTD_BY = "ENTD_BY";
	public static final String ENTD_ON = "ENTD_ON";
	public static final String LAYOUT_CODE = "LAYOUT_CODE";
	public static final String DTL_SL = "DTL_SL";
	public static final String BASE_CURR = "BASE_CURR";
	public static final String SOURCE_TABLE = "SOURCE_TABLE";
	public static final String SOURCE_KEY = "SOURCE_KEY";
	public static final String GLOBAL_ERRORS= "GLOBAL_ERRORS";
	public static final String RECORD_ERRORS = "RECORD_ERRORS";
	public static final String TOTAL_ERRORS = "TOTAL_ERRORS";
	public static final String MAIN_TABLE = "M";
	public static final String DETAIL_TABLE = "D";
	public static final String ERROR_MAIN_TABLE = "EM";
	public static final String ERROR_DETAIL_TABLE = "ED";
	public static final String HEADER_TABLE = "H";
	public static final String FILE_TYPE = "F";
	public static final String RECORD_TYPE = "R";
	public static final String RECORD_NO = "REC_SL";
	public static final String FIELD_CODE = "FIELD_CODE";
	public static final String ERROR_CODE = "ERROR_CODE";
	public static final String ERROR_CONTENT = "ERROR_CONTENT";
	public static final String FILE_HEADER = "FILE_HEADER";
	public static final String CBD = "CBD";
	public static final String VARIABLE_LENGTH_FILE = "2";
	public static final String FIXED_LENGTH_FILE = "1";
	public static final String RETURN_EVENT_REQUIRED = "1";
	public static final String DATE = "DATE";
	public static final int OUTWARD  = 2;
	public static final String UPLD_BY = "UPLD_BY";
	public static final String VALIDATION = "VALIDATION";
	public static final String PGM_SOURCE_TABLE = "PGM_SOURCE_TABLE";
	public static final String PGM_SOURCE_KEY = "PGM_SOURCE_KEY";
	public static final String PGM_ID= "PGM_ID";
	
	//Agency Bank Claims
	public static final String AGBRN_CBS = "AGBRN_CBS";
	public static final String TXN_TYPE = "TXN_TYPE";
	public static final String AGBK_CIF = "AGBK_CIF";
	public static final String SEC_CODE = "SEC_CODE";
	public static final String TRAN_DATE = "TRAN_DATE";
	public static final String REDEMPTION_INTEREST_FILE = "I";
	public static final String BOND_REDEMPTION_FILE = "R";
	public static final String SUBCRIPTION_FILE = "S";
	public static final String CSA_CODE = "CSA_CODE";
	public static final String STL_CYCLE = "STL_CYCLE";
	public static final String RCV_SENT = "RCV_SENT";
	public static final String PHYSICAL_FILE = "PHY_FILE";
	public static final String SYSDATE = "SYSDATE";
	public static final String RCPT_MODE = "RCPT_MODE";
	public static final String PROC_STAT = "PROC_STAT";
	public static final String AGBRN_CBS_NEW = "AGBRN_CBS_NEW";
	public static final String AGBANK_CBS = "AGBANK_CBS";
	public static final String AGTRAN_CBS = "AGTRAN_CBS";
	public static final String AGBANK_CBS_NEW = "AGBANK_CBS_NEW";
	public static final String AGTRAN_CBS_NEW = "AGTRAN_CBS_NEW";
	public static final String STATUS = "STATUS";
	public static final String RECON_FLG = "RECON_FLG";
	public static final String HY_INT = "HY_INT";
	public static final String INT_OPT = "INT_OPT";
	
	
	//Interest Redemption Files-Agency Bank Claims
	public static final String INT_AGBRN = "IRBRN";
	public static final String INT_AMT1 = "IRAMT1";
	public static final String INTHY_AMT1 = "HIAMT1";
	public static final String INT_AMOUNT = "PIAMT";
	
	//Principal Redemption Files-Agency Bank Claims
	public static final String RDN_AGBRN = "PRBRN";
	public static final String RDN_AGBRN1 = "PRBRN1";
	public static final String RDN_AGBRN2 = "PRBRN2";
	public static final String RDN_AMOUNT = "PRAMT";
	public static final String RDN_AMOUNT1 = "PRAMT1";
	public static final String RDN_INT_OPT = "PRINTO";
	public static final String RDN_BLA_NUM = "PRLED";
	public static final String RDN_TRAN_DATE = "PRTRDT";
	public static final String RDN_REP_DATE	 = "PRRPDT";
	public static final String RDN_RED_DATE = "PRRDDT";
	public static final String HY_AGBRN = "HYBRN";
	
	//Subscription Files-Agency Bank Claims
	public static final String SUB_AGBRN = "SUBBRN";
	public static final String SUB_AMOUNT = "SUBAMT";
	public static final String SUB_BLA_NUM = "SUBLED";
	public static final String SUB_INT_OPT = "SUBINT";
	public static final String SUB_TRAN_DATE = "SUBDT";
	
	
	
	//Reconciliation-Agency Bank Claims
	public static final String OLD_BANK_CODE = "REOBAC";
	public static final String OLD_TRAN_CODE = "REOTRC";
	public static final String OLD_BRANCH_CODE = "REOBRN";
	public static final String NEW_BANK_CODE = "RENBAC";
	public static final String NEW_TRAN_CODE = "RENTRC";
	public static final String NEW_BRANCH_CODE = "RENBRN";
	public static final String OLD_AMT = "REOAMT";
	public static final String NEW_AMT = "RENAMT";
	
	//IGAA File-Key Codes
	public static final String IGAA_DAMT = "DAMT";
	public static final String IGAA_CAMT = "CAMT";
	public static final String IGCSC = "IGCSC";
	public static final String IGAA_INTERNAL_ACC = "IGAA_INTERNAL_ACC";
	public static final String IGAA_GLACC_CODE = "IGAA_GLACC_CODE";
	public static final String IGAA_BRN_CODE = "IGAA_BRN_CODE";
	public static final String IGAMT = "IGAMT";
	
	//added by bala	
	public static final String IGAA_SRC_TABLE = "IGAA";
	public static final String IGAA_ERROR_SRC_TABLE = "IGAAFILEERR";
	//added by bala
	
	//ECS File-Key Codes
	public static final String MICR_INST = "ECTRAN";
	public static final String MICR_CITY = "ECMCIT";
	public static final String MICR_BANK = "ECMBAN";
	public static final String MICR_BRANCH = "ECMBRN";
	public static final String CLG_DATE = "CLG_DATE";
	public static final String CLG_BATCH = "CLG_BATCH";
	public static final String SUBM_SL = "SUBM_SL";
	public static final String INTERNAL_ACNUM = "INTERNAL_ACNUM";
	public static final String CUST_REF_NO = "CUST_REF_NO";
	public static final String CUST_REF_DATED="CUST_REF_DATED";
	public static final String ACNTLIEN_SL = "ACNTLIEN_SL";
	public static final String DESTINATION_MICR_CODE = "DEST_MICR";
	public static final String ECS_SRC_TABLE = "PORTALAGCLOG";
	public static final String ECS_MAIN_SRC_TABLE = "ECSSUBM";
	public static final String ECS_ERR_MAIN_SRC_TABLE = "ECSFILEERR";
	public static final String AGCLOG_SRC_KEY = "AGCLOG_SRC_KEY";
	public static final String P_ECS_PGM_ID = "PPECSUPLD";
	public static final String TOTAL_AMOUNT = "TOTAL_AMOUNT";
	public static final String ECS_AMOUNT = "ECAMT";
	
	
	
	//Positive Pay File-Key Codes
	public static final String FILE_ACNUM = "FILE_ACNUM";
	public static final String ACNUM = "ACNUM";
	public static final String CHQPFX = "CHQPFX";
	public static final String CHQNUM = "CHQNUM";
	public static final String CHQDATE = "CHQDAT";
	public static final String AMOUNT = "AMOUNT";
	public static final String FVGNAM = "FVGNAM";
	public static final String INSTYP = "INSTYP";
	public static final String FVGNAME1 = "FVGNAME1";
	public static final String FVGNAME2 = "FVGNAME2";
	public static final String POSPAY_SRC_TABLE = "POSPAYUPLD";
	public static final String POSPAY_ERR_SRC_TABLE = "POSPAYFILEERR";
	
	
	//R12 MNSB -Done by Bala
	public static final String HEADER_UDCH_CODE = "H_UDCH_CODE";
	public static final String ADV_NUMBER = "ADV_NUMBER";
	public static final String ADV_YEAR = "ADV_YEAR";
	public static final String ADV_SUFFIX = "ADV_SUFFIX";
	public static final String ADV_DATE = "ADV_DATE";
	public static final String ADV_TYPE = "ADV_TYPE";
	public static final String ADV_AMOUNT = "ADV_AMOUNT";
	public static final String VALUE_DATE = "VALUE_DATE";
	public static final String ACNT_MONTH = "ACNT_MONTH";
	public static final String ACNT_YEAR = "ACNT_YEAR";
	public static final String GHD_SCHM_CODE = "GHD_SCHM_CODE";
	public static final String HEADER_INT_ACNUM = "H_INT_ACNUM";
	public static final String HEADER_GLACC_CODE = "H_GLACC_CODE";
	public static final String HEADER_BRN_CODE = "H_BRN_CODE";
	public static final String RECORD_UDCH_CODE = "R_UDCH_CODE";
	public static final String RECORD_INT_ACNUM = "R_INT_ACNUM";
	public static final String RECORD_GLACC_CODE = "R_GLACC_CODE";
	public static final String RECORD_BRN_CODE = "R_BRN_CODE";
	public static final String PYMTAMT = "PYMT_AMT";
	public static final String RCPTAMT = "RCPT_AMT";
	public static final String MNSB_CLG_HS_CODE = "MNSB_CLG_HS_CODE";
	public static final String MNSB_CLG_TYPE = "MNSB_CLG_TYPE";
	public static final String MNSB_RTN_INDICATOR = "MNSB_RTN_INDICATOR";
	public static final String MNSB_UTR = "MNSB_UTR";
	public static final String UTR_NO = "UTR_NO";
	public static final String MNSB_RCVD_DATE_TIME = "MNSB_RCVD_DATE_TIME";
	public static final String MNSB_FIN_RTN_INDICATOR = "MNSB_FIN_RTN_INDICATOR";
	public static final String SENDER_TO_RECEIVER_INFO = "SENDER_TO_RECEIVER_INFO";
	public static final String RELATED_REF_NUM = "RELATED_REF_NUM";
	public static final String MNSB_PRNT_CLG_TYPE = "MNSB_PRNT_CLG_TYPE";
	public static final String RMIFSC = "RMIFSC";
	public static final String RMFLAG = "RMFLAG";
	public static final String RMAMT = "RMAMT";
	public static final String MNSB_BK_AC_NUM = "MNSB_BK_AC_NUM";
	public static final String MNSB_SRC_TABLE = "MNSBMSGS";
	public static final String MNSB_ERROR_SRC_TABLE = "MNSBFILEERR";
	

	///*Added by Saravanavel***/
	public static final String FILE_INVENTORY_NO ="FILE_INVENTORY_NO";
	public static final String SYSTEM_CODE ="FILE_INVENTORY_NO";
	public static final String FILEERROR_TABLE ="FILEERR";
	
		
	///*Added by Saravanavel***/
	
	public static final String INVENTORY_NO ="INVENTORY_NO";
	public static final String BANK_APPLICATION_IDENTIFIER ="BANK_APPLICATION_IDENTIFIER";                         
	public static final String MESSAGE_TYPE="MESSAGE_TYPE" ;
	public static final String SUB_MESSAGE_TYPE="SUB_MESSAGE_TYPE";                                    
	public static final String SENDER_ADDRESS = "SENDER_ADDRESS";                                     
	public static final String RECEIVER_ADDRESS="RECEIVER_ADDRESS";
	public static final String OPEN_NTFN_FLG="OPEN_NTFN_FLG";
	public static final String NON_DLVRY_FLG="NON_DLVRY_FLG";                                       
	public static final String OBS_PERIOD="OBS_PERIOD";                                          
	public static final String MUR="MUR";                                                 
	public static final String DUP_EMI_FLAG="DUP_EMI_FLAG";                                        
	public static final String SRV_IDENTIFIER="SRV_IDENTIFIER";                                      
	public static final String ORIG_DATE="ORIG_DATE";                                           
	public static final String ORIG_TIME="ORIG_TIME";                                           
	public static final String TEST_FLAG="TEST_FLAG";                                           
	public static final String SEQ_NUM="SEQ_NUM";                                             
	public static final String FILLER="FILLER";                                              
	public static final String PRIORITY="PRIORITY";  
	public static final String MESSAGE_ID="MESSAGE_ID";  
	public static final String INPUT_OUTPUT_IDENTIFIER="INPUT_OUTPUT_IDENTIFIER";  
	public static final String DLVRY_FLG="DLVRY_FLG";
	
	//Program IDs
	public static final String  AGSRV_PGM_ID= "EAGBCLAUTH";
	public static final String  AGBRCN_PGM_ID= "EAGBKRECON";
	public static final String  PDOFILEERR_PGM_ID= "PDOFILEERR";
	public static final String  IGAA_FILE_SUCCESS_PGM_ID= "EIGAA";
	public static final String  IGAA_FILE_ERROR_PGM_ID= "IGAAFILEERR";
	public static final String NETSECFX = "PCSAFILEPROC";
	public static final String DADSNN_PGM_ID = "DADSNN";
	public static final String PDO_ISIN = "SSISIN";
	public static final String  ECS_PGM_ID= "ECSSUBM";
	public static final String  ECS_ERROR_PGM_ID= "ECSFILEERR";
	public static final String  POSITIVEPAY_PGM_ID= "POSPAYUPLD";
	public static final String  POSITIVEPAY_ERROR_PGM_ID= "POSPAYUPLD";
	public static final String MNSB_FILE_ERROR_PGM_ID = "MNSB";
	public static final String MNSB_FILE_PGM_ID = "PR12MNSBUPLD";	
	
	
	//Miscellaneous
	
	public static final String PDO_DATE_FORMAT = "ddMMyyyy";
	public static final String CMDF_UPLD_DATE = "dd-MM-yyyy";
	public static final String REQUIRED_DATE_FORMAT = "dd-MMM-yyyy";
	public static final String CCIL_SYSTEM_CODE = "CCIL";
	public static final String DB_CBS_AC = "DB_AC_CBS";
	public static final String CR_CBS_AC = "CR_AC_CBS";
	public static final String PDO_DB_AC = "SSDBAC";
	public static final String PDO_CR_AC = "SSCRAC";
	public static final String DAD_DB_AC = "NSDBAC";
	public static final String DAD_CR_AC = "NSCRAC";
	public static final String NETFSX_RECEIVED = "R";
	public static final String NETFSX_SENT = "S";
	
	//MNSB
	public static final String MNSB_PARNT_INVNUM = "MNSB_PARNT_INVNUM";
	public static final String MNSB_MICR_CODE = "MMICRC";
	public static final String MNSB_VALUE_DATE = "MVDATE";
	public static final String MNSB_EFFECTIVE_DATE = "MEDATE";
	public static final String MNSB_INT_ACC_NUM = "INT_ACCNUM";
	public static final String MNSB_GL_CODE = "GL_CODE";
	public static final String MNSB_ACCNUM = "MACCNO";
	public static final String MNSB_AMT = "MAMT";
	public static final String MNSB_CAMT = "CAMT";
	public static final String MNSB_DAMT = "DAMT";
	public static final String MNSB_DCFLAG = "MLEG";
	public static final String MNSB_DFLAG = "D";
	public static final String MNSB_CFLAG = "C";
	public static final String MNSB_ZERO_BATCH = "ZERO_BATCH";
	public static final String MNSB_EFFT_DATE = "EFFT_DATE";
	
	//Brokerage 
	public static final String  BLABRK_PGM_ID= "EAGBCLAUTH";
	public static final String  BLABRK_BRN_CODE= "BBRN";
	public static final String  BLABRK_LEG_NO= "BLEGNO";
	public static final String  BLABRK_DATE= "BDATE";
	public static final String  BLABRK_AMT= "BAMT";
	public static final String  BLABRK_ADV_NO= "BADVNO";
	public static final String  BLABRK_EDATE= "BEDATE";
	public static final String  BLABRK_FLAG= "BFLAG";
	
	
	//
	public static final String  CCIL_BLOCK_RETRY_PROCESS= "PCCILBLOCKRETRYPROC";
	public static final String  CCIL_SETTLEMENT_PROCESS= "PCCILSETTLPROC";
	public static final String CLG_TYPE = "CLG_TYPE";
	public static final String CLGH_CODE= "CLGH_CODE";

	public static final String MNSB_RTN_FLAG = "MNSB_RTN_FLAG";
	
	public static final String CCIL_PGM_ID = "PCCILACNTSBLCK";
	
//PDO SECURITY FILE CONSTANTS
	
	public static final String PDODTE = "PDODTE";
	public static final String DACCNO = "DACCNO";
	public static final String CACCNO = "CACCNO";
	public static final String ISIN = "ISIN";
	public static final String GENSP = "GENSP";
	public static final String PDOAMT = "PDOAMT";
	public static final String PDOTXN = "PDOTXN";
	public static final String TXNREF = "TXNREF";
	public static final String PDSTAT = "PDSTAT";
	public static final String TMSTMP = "TMSTMP";
	public static final String TXNID = "TXNID";
	public static final String BLAMT = "BLAMT";
	
	public static final String PDO_MSG_ID = "PDO_MSG_ID";
	public static final String PDO_FILE_NAME = "PDO_FILE_NAME";
	public static final String PDO_REC_CNT = "PDO_REC_CNT";
	public static final String PDO_HDR_AMT = "PDO_HDR_AMT";
	public static final String PDO_FILE_STAT = "PDO_FILE_STAT";
	public static final String PDO_HDR_DATE = "PDO_HDR_DATE";
	public static final String PDO_HDR_REMARKS = "PDO_HDR_REMARKS";
	
	public static final String PDO_PGM_ID = "PPDO";
	public static final String PDO_ERR_PGM_ID = "PPDOERR";
	
	public static final String D_INTERNAL_ACNUM = "D_INTERNAL_ACNUM";
	public static final String C_INTERNAL_ACNUM = "C_INTERNAL_ACNUM";
	
   //DAD FILE CONSTANTS
	
	public static final String DADDTE = "DADDTE";
	public static final String DADACN = "DADACN";
	public static final String DACACN = "DACACN";
	public static final String DADAMT = "DADAMT";
	public static final String DBLAMT = "DBLAMT";
	public static final String TXNCOD = "TXNCOD";
	public static final String DTXNID = "DTXNID";
	public static final String DADRSN = "DADRSN";
	public static final String DDTXN = "DDTXN";

	public static final String DAD_MSG_ID = "DAD_MSG_ID";
	public static final String DAD_FILE_NAME = "DAD_FILE_NAME";
	public static final String DAD_REC_CNT = "DAD_REC_CNT";
	public static final String DAD_HDR_AMT = "DAD_HDR_AMT";
	public static final String DAD_FILE_STAT = "DAD_FILE_STAT";
	public static final String DAD_HDR_DATE = "DAD_HDR_DATE";
	public static final String DAD_HDR_REMARKS = "DAD_HDR_REMARKS";
	
	public static final String DAD_PGM_ID = "PDAD";
	public static final String DAD_ERR_PGM_ID = "PDADERR";
	
	public static final String PDO_SRC_TABLE = "SECSTTL";
	public static final String PDO_ERR_SRC_TABLE = "SECSTTLERR";
	public static final String PDO_BLOCKNG_PGM_ID = "PTXBLOCKPROC";
	public static final String PDO_STLMT_PGM_ID = "PTXSETTLEMENT";

	public static final String MBRSHP_MSG_ID = "MBRSHP_MSG_ID";
	public static final String MBRSHP_STATUS = "MBRSHP_STATUS";
	public static final String MBRSHP_DATETIME = "MBRSHP_DATETIME";
	public static final String MBRSHP_REMARKS = "MBRSHP_REMARKS";
	
	public static final String MBRSHP_PGM_ID = "PNDSMBRSHP";
	public static final String MBRSHP_ERR_PGM_ID = "PNDSMBRSHPERR";
	
	public static final String NDSMBR_SRC_TABLE = "NDSMBR";
	public static final String NDSMBR_PGM_ID = "PNDSMBR";
	public static final String NDSMBR_PROCESS_PGM_ID = "EPROCESSNDSMBR";
	public static final String NDSMBR_ERR_PGM_ID = "PNDSMBRERR";
	public static final String NDSMBR_ERR_SRC_TABLE = "NDSMBRERR";
	
	//E-Tax Collection 
	public static final String ETAXCOLL_IFSC = "TXIFSC";
	public static final String ETAXCOLL_PAID_DATE = "TXDATE";
	public static final String ETAXCOLL_PGM_ID = "PETAXCOLL";
	public static final String ETAXCOLL_ERR_PGM_ID = "PETAXCOLLERR";
	public static final String ETAXCOLL_STLMT_PGM_ID = "PETAXCOLLSTLMT";
	public static final String ETAXCOLL_KARANATAKA = "TAXKAR";
	public static final String ETAXCOLL_TAMILNADU = "TAXTN";
	public static final String ETAXCOLL_ODISHA = "TAXODI";
	public static final String ETAXCOLL_ACC_NUM = "ACC_NUM";
	public static final String ETAXCOLL_CIF = "CIF";
	public static final String ETAXCOLL_AMOUNT = "TXAMT";
	public static final String ETAXCOLL_HEAD_OF_ACC = "TXHDAC";
	public static final String ETAXCOLL_PAYMENT_MODE = "TXPMT";
	public static final String ETAXCOLL_SOURCE_TABLE = "ETAXCOLL";
	public static final String ETAXCOLL_ERR_SRC_TABLE = "ETAXCOLFILEERR";
	
	//PORTAL NEFT
	public static final String NEFT_IFSC = "PNIFSC";
	public static final String NEFT_DATE = "PNDATE";	
	public static final String NEFT_FAIL_REC = "NEFT_FAIL_REC";
	public static final String NEFT_READY_FLG = "NEFT_READY_FLG";
	public static final String NEFT_AMOUNT = "PNAMT";
	public static final String NEFT_SUC_REC ="PNSUCR";
	public static final String NEFT_VALID_FAIL = "PNVLDF";
	
	
	public static final String RTGS_FAIL_REC = "RTGS_FAIL_REC";
	public static final String RTGS_READY_FLG = "RTGS_READY_FLG";
	public static final String RTGS_IFSC = "PRIFSC";
	public static final String RTGS_DATE = "PRDATE";
	
	public static final String RTGS_AMOUNT = "PRAMT";
	public static final String RTGS_SUC_REC ="PRSUCR";
	public static final String RTGS_VALID_FAIL = "PRVLDF";

	public static final String RTGS_FILE_SUCCESS_SRC_TABLE="RTGSUPLD";

	public static final String  RTGS_FILE_ERR_SRC_TABLE="RTGSFILEERR";
	
	//ADDED BY AMRUTHA
	
	public static final String IFSC = "PNIFSC";
	public static final String PRIFSC = "PRIFSC";
	public static final String PNBTR = "PNBTR";
	public static final String PNTR = "PNTR";
	public static final String PRTRF = "PRTRF";
	public static final String PRUTR = "PRUTR";
	public static final String PRGUTR = "PRGUTR";
	public static final String  NEFT_FILE_SUCCESS_PGM_ID= "ENEFTFILE";
	public static final String  NEFT_FILE_ERROR_PGM_ID= "ENEFTFILEERR";
	public static final String  RTGS_FILE_SUCCESS_PGM_ID= "ERTGSFILE";
	public static final String  RTGS_FILE_ERROR_PGM_ID= "ERTGSFILEERR";
	public static final String  NEFT_FILE_SUCCESS_SRC_TABLE="NEFTUPLD";
	public static final String  NEFT_FILE_ERR_SRC_TABLE="NEFTFILEERR";
	
	public static final String SUCCESS_COUNT= "SUCCESS_COUNT";
	public static final String ERROR_COUNT= "ERROR_COUNT";
		
	public static final String  FILE_SRC_TABLE="CMDFUPLOAD";
	public static final String  NEFT_FILE_PGM_ID="PNEFTUPLD";
	public static final String  RTGS_FILE_PGM_ID="PRTGSUPLD";
	public static final String  POSPAY_FILE_PGM_ID="PPOSPAYUPLD";
	public static final String  SCH_DATE="SCH_DATE";
	
	public static final String NEFT_SENDER_ACNT_TYPE = "PNSACT";
	public static final String NEFT_SENDER_ACNT_NAME = "PNSACN";
	public static final String NEFT_SENDER_CLIENTADR1 = "PNSAD1";
	public static final String NEFT_SENDER_CLIENTADR2 = "PNSAD2";
	public static final String NEFT_SENDER_CLIENTADR3 = "PNSAD3";
	public static final String NEFT_SENDER_CLIENTADR4 = "PNSAD4";
	public static final String NEFT_SENDER_IFSC = "PNSIFS";
	
	//GEPG
	public static final String  GEPG_FILE_SUCCESS_PGM_ID= "PGEPGFILEUPLD";
	public static final String  GEPG_FILE_ERROR_PGM_ID= "PGEPGFILEUPLDERR";
	public static final String  GEPG_FILE_ERR_SRC_TABLE= "GEPGFILEERR";
	public static final String  GEPG_FILE_SUCCESS_SRC_TABLE= "GEPGFILE";
	public static final String  GEPG_IFSC= "IFSC";
	public static final String  GEPG_MICR= "GMICR";
	public static final String  GEPG_AMOUNT= "GAMT";
	public static final String  GEPG_AUTH_ID= "AUTHID";
	public static final String  GEPG_AUTH_DATE= "AUTHDT";
	public static final String  GEPG_RECORD_STATUS= "RECSTATUS";
	public static final String  GEPG_RECORD_REASON= "REASON";
	public static final String  GEPG_PAYMENT_MODE= "PYMTMODE";
	public static final String  GEPG_FINANCIAL_YEAR= "FINYEAR";
	public static final String  GEPG_PAO_CODE= "PAOCODE";
	public static final String  GEPG_INT_ACCNUM= "INTACCNUM";
	
//DVP DEALS 
	public static final String QUEUE_NAME = "QNAME";//Mahaboob S 11-01-2015
	public static final String DVPDEALS_PGM_ID = "PDVPDEALS";
	public static final String DVPDEALS_ERR_PGM_ID = "PDVPDEALSERR";
	public static final String DVPDEALS_MSG_ID = "DVPDEALS_MSG_ID";
	//public static final String PDO_FILE_NAME = "PDO_FILE_NAME";
	//public static final String PDO_REC_CNT = "PDO_REC_CNT";
	//public static final String PDO_HDR_AMT = "PDO_HDR_AMT";
	//public static final String PDO_FILE_STAT = "PDO_FILE_STAT";
	public static final String DVPDEALS_DATETIME = "DVPDEALS_DATETIME";
	public static final String DVPDEALS_REMARKS = "DVPDEALS_REMARKS";
	public static final String DVPDEALS_SRC_TABLE = "DVPDEALS";
	public static final String DVPDEALS_ERR_SRC_TABLE = "DVPDEALSERR";
	public static final String DVPDEALS_TRAN_REFNUM = "DTRNRF";
	public static final String DVPDEALS_TRAN_DATE = "DTRNDT";
	public static final String DVPDEALS_STLMT_DATE = "DSTLDT";
	public static final String DVPDEALS_NDS_MEMID = "DNDSM";
	public static final String DVPDEALS_CLIENTNUM = "DCLNCD";
	public static final String DVPDEALS_ISIN = "DISIN";
	public static final String DVPDEALS_SECCODE = "DSECCD";
	public static final String DVPDEALS_MATDATE = "DMATDT";
	public static final String DVPDEALS_GENSPEC = "DGNSPC";
	public static final String DVPDEALS_SOURCEFLAG = "DSAFLG";
	public static final String DVPDEALS_SGLACNT = "DSGLAC";
	public static final String DVPDEALS_CSGLACNT = "DCSGLA";
	public static final String DVPDEALS_AMNT = "DAMT";
	public static final String DVPDEALS_SALEPRICE = "DSLPRC";
	public static final String AUTH_ON = "AUTH_ON";
	public static final String AUTH_BY = "AUTH_BY";
	
	public static final String REC_STATUS = "REC_STATUS";
	public static final String REC_ERROR_CODE = "REC_ERROR_CODE";
	public static final String BUSS_SUCC = "S";
	public static final String BUSS_FAIL = "F";
	
	//DVP RECON
	public static final String  DVPRCN_FILE_SRC_TABLE= "DVPRCNUPLD";
	
	public static final String  DSYSIN= "DSYSIN";
	public static final String  DTRAQU= "DTRAQU";
	public static final String  DTRDAT= "DTRDAT";
	public static final String  DTRCNT= "DTRCNT";
	public static final String  MSG_ID= "MSG_ID";
	public static final String  DATE_TIME= "DATETIME";
	public static final String  REMARKS= "REMARKS";
	public static final String DVPRCN_PGM_ID= "DVPRCNUPLD";
	public static final String DVPRCN_ERROR_PGM_ID= "DVPRCNUPLD";
	public static final String DVPRCN_SRC_TABLE = "DVPRCNUPLD";
	public static final String DVPRCN_ERR_SRC_TABLE = "DVPRCNFILEERR";
	public static final String DVPRCN_FILE_PGM_ID="PDVPRCNUPLD";
	public static final String IGAA_SETTLEMENT_PROCESS="PIGAAPOST";
	public static final String ADV_UDCH_CODE = "ADV_UDCH_CODE";
	public static final String SEND_BRN_CODE = "SEND_BRN_CODE";
	public static final String IGAA_CHNL = "IGAA_CHNL";

	public static final String BATCH_TIME="BATCH_TIME";
	public static final String NEFT_AUTO_AUTHORIZE="NAUTOAUTH";	
	
	//EPAY
	
	public static final String EXSD_VAL_FAILURE = "GV0004";
	public static final String ESIGN_VAL_FAILURE = "FV0003";
	public static final String ERROR_EFILE_PGMID = "PEFILEERROR";
	public static final String SUCCESS_EFILE_PGMID = "PEPAYPROC";
	public static final String ERROR_DESC = "ERROR_DESC";
	public static final String ERROR_MAP = "ERROR_MAP";
	public static final String EPAY_SRC_TABLE = "EPAYINQLOG";
	public static final String EPAY_SCRLFILE_PGMID="EPAYSCRLFILE";
	
	//ERECEIPTS
	public static final String ERCPFILE_PGM_ID = "PERCPFILE";
	public static final String ERCP_SIGNATURE_TAG_NOT_FOUND="FV0002";
	public static final String ERCP_XSD_VAL_FAILURE = "GV0004";
	public static final String ERCP_BK_SCROLL_FILE_PID = "ERCPSCRGEN";
	
	//NMNSB
	
	public static final String NMNSB_PARNT_INVNUM = "MNSB_PARNT_INVNUM";
	public static final String NMNSB_MICR_CODE = "MMICRC";
	public static final String NMNSB_VALUE_DATE = "MVDATE";
	public static final String NMNSB_EFFECTIVE_DATE = "MEDATE";
	public static final String NMNSB_INT_ACC_NUM = "INT_ACC";
	public static final String NMNSB_GL_CODE = "GL_CODE";
	public static final String NMNSB_ACCNUM = "MACCNO";
	public static final String NMNSB_AMT = "MAMT";
	public static final String NMNSB_CAMT = "CAMT";
	public static final String NMNSB_DAMT = "DAMT";
	public static final String NMNSB_DCFLAG = "MLEG";
	public static final String NMNSB_DFLAG = "D";
	public static final String NMNSB_CFLAG = "C";
	public static final String NMNSB_ZERO_BATCH = "ZERO_BATCH";
	public static final String NMNSB_EFFT_DATE = "EFFT_DATE";
	public static final String NMNSB_CITY_CD = "CITY_CODE";
	public static final String NMNSB_BANK_CD = "BANK_CODE";
	public static final String NMNSB_CLG_HS_CODE = "NMNSB_CLG_HS_CODE";	
	
	// For CHRS
	public static final String CHRS_MSG_REF_NUM = "REF_NUM";
	public static final String CHRS_TOT_AMT = "TOT_AMT";
	public static final String CHRS_RECORD_NUM ="CHRNUM";
	public static final String CHRS_BRN_CODE ="CHBRN";
	public static final String CHRS_GL_ACC ="CHGLAC";
	public static final String CHRS_GL_CODE ="CHGLCD";
	public static final String CHRS_ACC ="CHACC";
	public static final String CHRS_CURRENCY ="CHCURR";
	public static final String CHRS_AMOUNT ="CHAMT";
	public static final String CHRS_DB ="D";
	public static final String CHRS_CR ="C";
	public static final String CHRS_DBCRFLG ="CHDBCD";
	public static final String  CHRS_FILE_SUCCESS_PGM_ID= "PCHRSTRANFILEPROC";
	public static final String  CHRS_FILE_ERROR_PGM_ID= "PCHRSFILEERR";
	public static final String  CHRS_FILE_ERR_SRC_TABLE= "CHRSFILEERR";
	public static final String  CHRS_FILE_SUCCESS_SRC_TABLE= "CHRSTRANFILE";
	public static final String  CHRS_SUCCESS_RES_PGM_ID= "PCHRSSUCRESP";
	public static final String  CHRS_FAIL_RES_PGM_ID= "PCHRSFAILRESP";	
	public static final String  CHRS_TRAN_FILE_ERROR_PGM_ID= "PCHRSTRANFILEUPLDERR";
	public static final String CHRS_GL_HEAD ="CHGLHD";
	//CHRSPYMTFILE
	public static final String CHRSPYMT_MSG_REFNO = "CHMREF";
	public static final String CHRSPYMT_AMOUNT = "CHAMT";
	public static final String CHRSPYMT_TOTAL_AMT = "CHTAMT";
	public static final String CHRSPYMT_AUTH_ID = "AUTH_BY";
	public static final String CHRSPYMT_IFSC = "CHIFSC";
	public static final String CHRSPYMT_ACCOUNT_TYPE = "CHBATY";
	public static final String CHRSPYMT_FILE_SUCCESS_PGM_ID = "PCHRSPYMTFILE";
	public static final String CHRSPYMT_FILE_ERROR_PGM_ID = "PCHRSPYMTFILEERR";
	public static final String CHRSPYMT_FILE_SUCCESS_SRC_TABLE = "CHRSPYMTFILE";
	public static final String CHRSPYMT_FILE_ERROR_SRC_TABLE = "CHRSFILEERR";
	public static final String CHRSPYMT_CURRENCY = "CHCURR";
	public static final String CHRSPYMT_REL_REFNO = "CHRREF";
	public static final String CHRSPYMT_PAYMENT_REFNO = "CHPREF";	
    public static final String  MNSB_SETTLEMENT_PROCESS= "PMNSBSETLSUCC";	
	public static final String CHRSPYMT_FILE_PROCESS = "CMDFUPLDSTATUS";
	public static final String CHRSPYMT_FILE_PROCESS_PGM_ID = "PCHRSPYMTPROC";
	// DFTRF

	// For DEAF
	public static final String DEAF_TOT_AMT = "DFTOTA";
	public static final String DEAF_RECORD_NUM = "DFREC";
	public static final String DEAF_BRN_CODE = "DFBRN";
	public static final String DEAF_FILE_SUCCESS_PGM_ID = "PDEAFTRANFILEPROC";
	public static final String DEAF_FILE_ERROR_PGM_ID = "PDEAFFILEERR";
	public static final String DEAF_FILE_ERR_SRC_TABLE = "DEAFTRANFILEERR";
	public static final String DEAF_SUCCESS_RES_PGM_ID = "PDEAFSUCRESP";
	public static final String DEAF_FAIL_RES_PGM_ID = "PDEAFFAILRESP";
	public static final String DEAF_TRAN_FILE_ERROR_PGM_ID = "PDEAFTRANFILEUPLDERR";
	public static final String DEAF_FILE_SUCCESS_SRC_TABLE = "DEAFTRANFILE";
	public static final String DEAF_AUTH_NTFN = "PDEAFAUTHNTFN";
	public static final String DFTRFDTL_REC_NUM = "DFNUM";
	public static final String DFTRFDTL_DEAF_CODE = "DFBKC";
	public static final String DFTRFDTL_IB_NOFACC = "DFIB";
	public static final String DFTRFDTL_IB_AMT = "DFIBA";
	public static final String DFTRFDTL_NIB_NOFACC = "DFNIB";
	public static final String DFTRFDTL_NIB_AMT = "DFNIBA";
	public static final String DFTRFDTL_OTH_NOFACC = "DFOTH";
	public static final String DFTRFDTL_OTH_AMT = "DFOTHA";
	public static final String DFTRFDTL_REMARK = "DFREM";
	public static final String DFTRF_MSG_TYPE = "DFMTYP";
	public static final String DFTRF_MSG_DT = "DFMDT";
	public static final String DFTRF_MSG_REF = "DFMREF";
	public static final String DFTRF_TOT_AMOUNT = "DFTOTA";
	public static final String DFTRF_NOOF_ACC = "DFNACC";
	public static final String DFTRF_DATE_OF_TRF = "DFDTRF";
	
	
		// For DEAF Claim
	public static final String DFCLM_MSG_TYPE ="DFCMTP";
	public static final String DFCLM_MSG_DT ="DFCMDT";
	public static final String DFCLM_MSG_REF ="DFCMRF"; 
	public static final String DFCLM_DEAF_CODE ="DFCDCD";
	public static final String DFCLM_TOT_CLAIM_AMOUNT ="DFCTCA";
	public static final String DFCLM_TOT_INT_CLAIMED ="DFCTIC";
	public static final String DFCLM_TOT_NOOF_ACC ="DFCTNA";
	public static final String DFCLM_DATE_OF_CLAIM ="DFCCDT";
    public static final String DFCLM_SRC_TABLE = "SOURCE_TABLE";
    public static final String DFCLM_SRC_KEY ="SOURCE_KEY";
    public static final String DFCLM_BENEF_IFSC ="DFCIFS";
    public static final String DFCLM_AC_TYPE ="DFCACT";
    public static final String DFCLM_AC_NUMBER ="DFCACN";
    public static final String DFCLM_AC_NAME = "DFCNAM";
    public static final String DFCLM_SETTLE_MODE = "DFCSTM";
    public static final String DFCLMDTL_ENTITY_NUM = "ENTITY_NUM"; 
    public static final String DFCLMDTL_BRN_CODE = "BRN_CODE";
    public static final String DFCLMDTL_UPLD_DATE = "UPLD_DATE";
    public static final String DFCLMDTL_DAY_SL = "UPLD_SL";
    public static final String CLM_SL="CLM_SL";
    public static final String DFCLMDTL_CLAIM_SL = "";
    public static final String DFCLMDTL_REC_NUM = "DFCNUM";
    public static final String DFCLMDTL_TRF_REF_NUMBER = "DFCTRN";
    public static final String DFCLMDTL_CLAIM_AMOUNT = "DFCAMT";
    public static final String DFCLMDTL_INTEREST_AMOUNT = "DFCIAM";
    public static final String DFCLMDTL_NOF_ACS_CLAIMED = "DFCNOA";
    public static final String DFCDEPDTL_REC_NUM = "DFDNUM";
    public static final String DFCDEPDTL_DEP_NAME = "DFDNAM";
    public static final String DFCDEPDTL_PRIN_AMT_PAID = "DFDAMT";
    public static final String DFCDEPDTL_INT_AMT_PAID = "DFDIAM";
    public static final String DFCDEPDTL_ACT_CLM_DT = "DFDADT";
    
	public static final String DEAF_CLM_FILE_SUCCESS_PGM_ID= "PDEAFCLAIMFILEPROC";
	public static final String DEAF_CLM_FILE_ERROR_PGM_ID= "PDEAFCLAIMFILEUPLDERR";
	public static final String DEAF_CLM_FILE_ERR_SRC_TABLE= "DEAFCLAIMFILEERR";
	public static final String DEAF_CLM_SUCCESS_RES_PGM_ID= "PDEAFCLAIMSUCRESP";
	public static final String DEAF_CLM_FAIL_RES_PGM_ID= "PDEAFCLMFAILRESP";	
	public static final String DEAF_CLM_FILE_SUCCESS_SRC_TABLE = "DEAFCLAIMFILE";
    public static final String MEM_CIF_CODE="MEM_CIF_CODE";
    
    public static final String SRV_REF_NUM="SRV_REF_NUM";
    public static final String CFS_NUM="CFS_NUM";
    public static final String FORMAT_CODE="FORMAT_CODE";
    public static final String FILE_NAME="FILE_NAME";
    public static final String MODE="MODE";
    public static final String LTADDR="LTADDR";
    
    
    public static final String BRANCH_CODE="BRANCH_CODE";
    public static final String BANK_CIF="BANK_CIF";
    public static final String INVNUM="INVNUM";
    public static final String RCP_PERSIST_SUCC_PGM="ERCPVAL";
    public static final String RCP_PERSIST_FAIL_PGM="ERCPFAIL";
    public static final String RCP_VAL_SUCC_PGM="ERCPVALSUCC";
    public static final String RCP_VAL_FAIL_PGM="ERCPVALFAIL";
    public static final String RCP_CON_SUCC_PGM="ERCPCONSCH";    
    public static final String RECEIPTS="RECEIPTS";
    public static final String RECEIPTSCON ="RECEIPTSCON";
    public static final String RECEIPTSLOG="ERCPINQLOG";
    public static final String INIT="INIT";
    public static final String VALIDATE="VAL";
    public static final String CONSOLIDATE="CON";
    public static final String SETTLEMENT="STL";    
    public static final String STAGESUCCESS="S";
    public static final String STAGEFAILURE="R";
    public static final String PROC_SUCCCESS="000";
    public static final String REPORT="RPT";
    public static final String REPORT_SCHEDULE="RPTSCH";
    public static final String ERCP="ERCP";
    public static final String RCP_STLMT_PGMID="ERCPSTLMT";
    public static final String SG_SRCTABLE="SGINQLOG";
    public static final String EPAY_VAL_PGM="EPAYVAL";
    public static final String EPAY_PERSIST_FAIL_PGM="EPAYFAIL";
    public static final String EPAY_VAL_SUCC_PGM="EPAYVALSUCC";
    public static final String EPAY_VAL_FAIL_PGM="EPAYVALFAIL";
    public static final String EPAY_PYMTFILE="PYMTFILE";
    //Exception related constants
    public static final String EXCP_SRCTABLE="EXCPLOG";
    public static final String EXCP_PGMID="EXCEPTIONS";
    public static final String PORTAL_SYSTEM="P";
    public static final String EXTERANL_SYSTEM="S";
	public static final String PARTID="PARTID";
	public static final String CMN_SRCKEY = "CMN_SRCKEY";
    public static final String CORR_ID="CORR_ID";

		public static final String RCPNEFT_PGM="PRCPEOSNEFTINIT";
	public static final String RCPRTGS_PGM="PRCPEOSRTGSINIT";
	public static final String RCPCN_PGM="PRCPEOSCNINIT";
	public static final String RCPBP_SESSLOG="BPSESSLOG";
    public static final String SRC_REF_NUM="SRC_REF_NUM";
    public static final String IW_PYMNTS="IWPYMNTS";
    public static final String NEFT_N02_SRC_TABLE="NEFTHEADER";
// --END
	public static final String CPIN_SUCCESS="CN0000";
    public static final String CPIN_EXCP_CHK="CN9999";
    public static final String CPIN_DUP_CHK="CN0001";
	public static final String CPIN_SIGN_CHK="CN0002";
	public static final String CPIN_AMT_CHK="CN0003";
	public static final String CPIN_SYSCD_CHK="CN0004";
	public static final String CPIN_EXPDT_CHK="CN0005";
	public static final String CPIN_HOACHK_CHK="CN0006";
	public static final String CPIN_CPIN_ERR="CN0007";
	public static final String CPIN_SYSCD_ERR="CN0008";
	public static final String CPIN_TOTAMT_ERR="CN0009";
	public static final String CPIN_CHNDTLS_ERR="CN0010";
	public static final String CPIN_CHNDTLS_CNT="CN0011";
	public static final String CPIN_EXPDT_INVD="CN0012";
	public static final String CPIN_TAXBRK_ERR="CN0013";
	
	public static final String EVENT="E";
	public static final String MESSAGE="M";
	public static final String SRC_TABLE="SRC_TABLE";
	public static final String STAGE1="1";
	public static final String STAGE2="2";
	public static final String STAGE5="5";
	public static final String STAGE6="6";
	public static final String SUCCESS="S";
	public static final String REJECTED="R";

	public static final String NEFT_EXCP_SYS_CODE="NFTEXP";
	
	public static final String REQ_DATE="REQ_DATE";
    public static final String RECVD_DATE="RECVD_DATE";
	public static final String CFS_INV_NUM = "CFS_INV_NUM";
	public static final String DIRECTION="DIRECTION";
	public static final String PART_ID = "PART_ID";
	public static final String SRC_KEY = "SRC_KEY";
	
	public static final String INV_NUM = "INVNUM";
	public static final String USER_CREDIT_REF = "USCRRF";
	public static final String APBS_TAPE_INP = "APTPIN";
	public static final String SPNSR_IIN = "SPRIIN";
	public static final String TOT_ITMS = "TOTITM";
	public static final String TOT_AMT = "TOTAMT";
	public static final String RQ_SL = "RQSL";
	public static final String DEST_IIN = "DSTIIN";
	public static final String BEF_ADHR_NO = "BFADNO";
	public static final String BEF_NAME = "BFNME";
	public static final String DBTR_ID = "DBTRID";
	public static final String TRN_REF = "TRNREF";
	public static final String STLMT_AMT = "SMTAMT";
	public static final String STS_FLG = "STATUS";
	public static final String DEST_ACC_TYPE = "DTACTY";
	public static final String APBARES_SUCCESS_SRC_TAB = "APBSRESFILE";
	public static final String APBSRES_SUCCESS_PGM = "INWRES";
	public static final String FILETYPE = "FILE_TYPE";
	
	//qpayres
	public static final String QPAYRES_ENTITY = "ENTITY";
	public static final String QPAYRES_FILE_NAME="FLNAME";
	public static final String QPAYRES_PART_ID="PARTID";
	public static final String QPAYRES_STAGE_ID="STS";
	public static final String QPAYRES_STAGE_STATUS="S";
	public static final String QPAY_SUCCESS_SRC_TAB="QPAYRESFILE";
	public static final String QPAY_SUCCESS_PGM="RESFILE";
	public static final String QPAYRES_TX_ID="HTRAC";
	public static final String QPAYRES_ACKID="MSGREF";
	public static final String QPAYRES_TOTAL_AMT="TOTAMT";
	public static final String QPAYRES_SERVICE_CODE="SRVCOD";
	public static final String QPAYRES_TOTAL_RECO="TOTRAN";
	public static final String QPAYRES_STMT_DATE="STDATE";


}
