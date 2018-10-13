package com.bo.file.constants;

public class FileErrorConstants {
	
	public static final String SUCCESS = "000";
	public static final String RECORD_LENGTH_MISMATCH = "001";
	public static final String PATTERN_MISMATCH = "002";
	public static final String INVALID_DATE_FORMAT = "003";
	public static final String CBD_MISMATCH = "004";
	public static final String FIELD_COUNT_MISMATCHED = "101";
	public static final String VALIDATION_SUCCESS = "1";
	public static final String VALIDATION_FAILURE = "2";	
	public static final String INVALID_IFSC = "050";	
	public static final String SIGN_VERIFICATION_FAILED = "051";
		
//CHRSPYMT
public static final String CHRSPYMT_INVALID_CURRENCY = "031";
public static final String CHRSPYMT_INVALID_ACC_TYPE = "016";
public static final String CHRSPYMT_AMOUNT_MISMATCH =  "017";
public static final String CHRSPYMT_TOTAL_AMOUNT_INDV_SUM_ZERO = "034";

	// ---------BEGIN DEAFTRAN VALIDATION
	// ---------SARAVANAVEL ON 01-05-2015 11.13AM
	public static final String DFTRF_UNEXPECTED_ERROR = "100";
	public static final String DFTRF_SUCCESS = "0000";
	public static final String DFTRF_ACCOUNT_DETAIL_UNAVAILABLE = "005";
	public static final String DFTRF_INVALID_MESSAGE_TYPE = "011";
	public static final String DFTRF_TOTAL_AMOUNT_ZERO = "012";
	public static final String DFTRF_INVALID_HEADER_LENGTH = "013";
	public static final String DFTRF_INVALID_CBD = "014";
	public static final String DFTRF_AMOUNT_MISMATCH = "015";
	public static final String DFTRF_TOTAL_AMOUNT_INDV_SUM_ZERO = "016";
	public static final String DFTRF_INVALID_PAYMENT_REF_NO = "017";
	public static final String DFTRF_INVALID_FILE_UPLOAD = "018";
	public static final String DFTRF_DATE_NOT_EQ_TO_CBD = "019";
	public static final String DFTRF_INVALID_MSG_REF = "020";
	public static final String DFTRF_AMOUNT_ZERO_OR_LESS = "021";
	public static final String DFTRF_HEADER_INDIVAMT_MISSMATCH = "022";
	public static final String DFTRF_HEADER_INDIVAMT_SHOULDNOT_BE_ZERO = "023";
	public static final String DFTRF_INVAlID_VALUE_DATE = "024";
	public static final String DFTRF_INVALID_DEAF_REF_NO = "025";
	public static final String DFTRF_AMOUNT_NOT_TALLIED = "026";
	public static final String DFTRF_DUPLICATE_MSG_REFNUM = "027";
	public static final String DFTRF_HDR_INDV_ACC_MISMATCHED = "028";
	public static final String DFTRF_HDR_INDV_AMT_MISMATCHED = "029";
	public static final String DFTRF_DUPLICATE_DEAF_CODE = "030";	
	public static final String DFTRF_REC_ACC_ERR = "080"; 
	public static final String DFTRF_REC_AMT_ERR = "081"; 
	public static final String DFTRF_IB_ACC_ZERO = "082"; 
	public static final String DFTRF_IB_AMT_ZERO = "083"; 
	public static final String DFTRF_NIB_ACC_ZERO = "084"; 
	public static final String DFTRF_NIB_AMT_ZERO = "085"; 
	public static final String DFTRF_OTH_ACC_ZERO = "086"; 
	public static final String DFTRF_OTH_AMT_ZERO = "087"; 
	public static final String DFTRF_ALL_ACC_ISZERO = "089"; 
	public static final String DFTRF_REC_ALREADY_EXIST = "090"; 
	// ---------END DEAFTRAN VALIDATION	
	
	// ---------GURUPRASAD ON 19-02-2016 
	public static final String DFCLM_UNEXPECTED_ERROR = "100";
	public static final String DFCLM_SUCCESS = "000";
	public static final String DFCLM_ACCOUNT_DETAIL_UNAVAILABLE = "005";
	public static final String DFCLM_INVALID_MESSAGE_TYPE = "011";
	public static final String DFCLM_TOTAL_AMOUNT_ZERO = "012";
	public static final String DFCLM_INVALID_HEADER_LENGTH = "013";
	public static final String DFCLM_INVALID_CBD = "014";
	public static final String DFCLM_AMOUNT_MISMATCH = "015";
	public static final String DFCLM_TOTAL_AMOUNT_INDV_SUM_ZERO = "016";
	public static final String DFCLM_INVALID_PAYMENT_REF_NO = "017";
	public static final String DFCLM_INVALID_FILE_UPLOAD = "018";
	public static final String DFCLM_DATE_NOT_EQ_TO_CBD = "019";
	public static final String DFCLM_INVALID_MSG_REF = "020";
	public static final String DFCLM_AMOUNT_ZERO_OR_LESS = "021";
	public static final String DFCLM_HEADER_INDIVAMT_MISSMATCH = "022";
	public static final String DFCLM_HEADER_INDIVAMT_SHOULDNOT_BE_ZERO = "023";
	public static final String DFCLM_INVAlID_VALUE_DATE = "024";
	public static final String DFCLM_INVALID_DEAF_REF_NO = "025";
	public static final String DFCLM_AMOUNT_NOT_TALLIED = "026";
	public static final String DFCLM_DUPLICATE_MSG_REFNUM = "027";
	public static final String DFCLM_CLM_INDV_COUNT_MISMATCHED = "028";
	public static final String DFCLM_CLM_PRIN_AMT_MISMATCHED = "029";
	public static final String DFCLM_CLM_NOF_ACC_NOT_NUMBER = "030";
	public static final String DFCLM_INVALID_MSG_DATE = "031";
	public static final String DFCLM_INVALID_SETTLEMENT_CODE = "032";
	public static final String DFCLM_INVALID_REC_INDICATOR = "033";
	public static final String DFCLM_INVALID_DEPOSITOR_NAME = "034";
	public static final String DFCLM_INVALID_IFSC_CODE = "035";
	public static final String DFCLM_INVALID_ACC_NAME = "036";
	public static final String DFCLM_INVALID_ACC_NUM = "037";
	public static final String DFCLM_DUPLICATE_TRF_REF_NUM = "038";
	public static final String DFCLM_INVALID_CLAIM_DATE = "039";
	public static final String DFCLM_INVALID_AC_TYPE = "040";
	public static final String DFCLM_INVALID_CLM_DTLS_IND = "041";
	public static final String DFCLM_INVALID_CIF_CODE = "042";
	public static final String DFCLM_DUPLICATE_DEAF_CODE = "043";
	public static final String DFCLM_CLM_INVALID_RECORD_IND = "044";
	public static final String DFCLM_CLM_INT_AMT_MISMATCHED = "045";
	public static final String DFCLM_HDR_INDV_COUNT_MISMATCHED = "046";
	public static final String DFCLM_REC_ACC_ERR = "080"; 
	public static final String DFCLM_REC_AMT_ERR = "081"; 
	public static final String DFCLM_ACC_ZERO = "082"; 
	public static final String DFCLM_AMT_ZERO = "083"; 
	public static final String DFCLM_ALL_ACC_ISZERO = "089";
	public static final String DFDEPCLM_REC_ACC_ERR = "090"; 
	public static final String DFDEPCLM_REC_AMT_ERR = "091"; 
	public static final String DFDEPCLM_ACC_ZERO = "092"; 
	public static final String DFDEPCLM_AMT_ZERO = "093"; 
	public static final String DFDEPCLM_ALL_ACC_ISZERO = "094";
	public static final String DFDEPCLM_NOF_REC_MISMATCH = "095";
	// ---------END DEAFCLAIM VALIDATION

}
