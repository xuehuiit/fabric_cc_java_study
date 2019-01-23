package com.xuhuiit.fabric.chaincode.java.study;

import com.google.protobuf.ByteString;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hyperledger.fabric.shim.Chaincode;
import org.hyperledger.fabric.shim.ChaincodeBase;
import org.hyperledger.fabric.shim.ChaincodeStub;

import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * @author robert.feng
 * @create 2019-01-23
 * <p>
 * QQ: 411321681
 */
public class FabricCcJavaStudy extends ChaincodeBase {


    private static Log _logger = LogFactory.getLog(FabricCcJavaStudy.class);

    @Override
    public Response init(ChaincodeStub stub) {

        _logger.info(" Init Java Chaincode ");

        //当前方法
        String func = stub.getFunction();

        return newSuccessResponse();
    }


    @Override
    public Response invoke(ChaincodeStub stub) {

        _logger.info(" =====  Invoke java chaincode  ====== ");

        String function = stub.getFunction();

        List<String> params = stub.getParameters();


        if (function.equals("invoke")) {
            return invoke(stub, params);
        } else if (function.equals("query")) {
            return query(stub, params);
        } else if (function.equals("get")) {
            return get(stub, params);
        } else if (function.equals("set")) {
            return set(stub, params);
        } else if (function.equals("delete")) {
            return delete(stub, params);
        } else if (function.equals("GetHistoryForKey")) {
            return GetHistoryForKey(stub, params);
        } else if (function.equals("addNewBc")) {
            return addNewBc(stub, params);
        } else if (function.equals("querySearch")) {
            return querySearch(stub, params);
        } else if (function.equals("querySearch4Composite")) {
            return querySearch4Composite(stub, params);
        } else if (function.equals("set4Composite")) {
            return set4Composite(stub, params);
        } else if (function.equals("rangeQuery")) {
            return rangeQuery(stub, params);
        } else if (function.equals("querySearch4Pageing")) {
            return querySearch4Pageing(stub, params);
        } else if (function.equals("querySearch4Composite4Pageing")) {
            return querySearch4Composite4Pageing(stub, params);
        } else if (function.equals("rangeQuery4Pageing")) {

            return rangeQuery4Pageing(stub, params);

        } else if (function.equals("setPrivate")) {

            return setPrivate(stub, params);

        } else if (function.equals("getPrivate")) {

            return getPrivate(stub, params);

        } else if (function.equals("getChannelID")) {

            return getChannelID(stub, params);

        } else if (function.equals("getBinding")) {

            return getBinding(stub, params);

        } else if (function.equals("getTransient")) {

            return getTransient(stub, params);

        } else if (function.equals("getCreator")) {

            return getCreator(stub, params);

        } else if (function.equals("getSignedProposal")) {

            return getSignedProposal(stub, params);

        } else if (function.equals("getTxTimeStamp")) {

            return getTxTimeStamp(stub, params);

        } else if (function.equals("setStateValidationParameter")) {

            return setStateValidationParameter(stub, params);

        } else if (function.equals("getStateValidationParameter")) {

            return getStateValidationParameter(stub, params);

        }


        return null;


    }


    private Response invoke(ChaincodeStub stub, List<String> args) {


        return newSuccessResponse("invoke finished successfully", ByteString.copyFrom("", UTF_8).toByteArray());


    }

    private Response query(ChaincodeStub stub, List<String> args) {


        return newSuccessResponse("invoke finished successfully", ByteString.copyFrom("", UTF_8).toByteArray());


    }


    /**
     * get value
     * @param stub
     * @param args
     * @return
     */
    private Response get(ChaincodeStub stub, List<String> args) {


        if (args.size() < 1) {
            return newErrorResponse("Incorrect number of arguments. Expecting name of the person to query");
        }


        String key = args.get(0);
        String val	= stub.getStringState(key);
        if (val == null) {
            return newErrorResponse(String.format("Error: state for %s is null", key));
        }


        _logger.info(String.format("Query Response:\nName: %s, Amount: %s\n", key, val));
        return newSuccessResponse(val, ByteString.copyFrom(val, UTF_8).toByteArray());


    }


    /**
     * set value
     * @param stub
     * @param args
     * @return
     */
    private Response set(ChaincodeStub stub, List<String> args) {

        if (args.size() <  1) {
            return newErrorResponse("Incorrect number of arguments. Expecting 1");
        }

        String key = args.get(0);
        String parm_a = args.get(0);
        String parm_b = args.get(1);
        String parm_c = args.get(2);

        stub.putStringState(parm_a,parm_b);

        return newSuccessResponse("delete successs") ;

    }


    /**
     * delete value
     *
     * @param stub
     * @param args
     * @return
     *
     */
    private Response delete(ChaincodeStub stub, List<String> args) {


        if (args.size() <  1) {
            return newErrorResponse("Incorrect number of arguments. Expecting 1");
        }
        String key = args.get(0);
        // Delete the key from the state in ledger
        stub.delState(key);
        return newSuccessResponse("delete successs") ;


    }



    private Response GetHistoryForKey(ChaincodeStub stub, List<String> args) {


        return newSuccessResponse("invoke finished successfully", ByteString.copyFrom("", UTF_8).toByteArray());


    }

    private Response addNewBc(ChaincodeStub stub, List<String> args) {


        return newSuccessResponse("invoke finished successfully", ByteString.copyFrom("", UTF_8).toByteArray());


    }

    private Response querySearch(ChaincodeStub stub, List<String> args) {


        return newSuccessResponse("invoke finished successfully", ByteString.copyFrom("", UTF_8).toByteArray());


    }

    private Response querySearch4Composite(ChaincodeStub stub, List<String> args) {


        return newSuccessResponse("invoke finished successfully", ByteString.copyFrom("", UTF_8).toByteArray());


    }

    private Response set4Composite(ChaincodeStub stub, List<String> args) {


        return newSuccessResponse("invoke finished successfully", ByteString.copyFrom("", UTF_8).toByteArray());


    }

    private Response rangeQuery(ChaincodeStub stub, List<String> args) {


        return newSuccessResponse("invoke finished successfully", ByteString.copyFrom("", UTF_8).toByteArray());


    }

    private Response querySearch4Pageing(ChaincodeStub stub, List<String> args) {


        return newSuccessResponse("invoke finished successfully", ByteString.copyFrom("", UTF_8).toByteArray());


    }

    private Response querySearch4Composite4Pageing(ChaincodeStub stub, List<String> args) {


        return newSuccessResponse("invoke finished successfully", ByteString.copyFrom("", UTF_8).toByteArray());


    }

    private Response rangeQuery4Pageing(ChaincodeStub stub, List<String> args) {


        return newSuccessResponse("invoke finished successfully", ByteString.copyFrom("", UTF_8).toByteArray());


    }

    private Response setPrivate(ChaincodeStub stub, List<String> args) {


        return newSuccessResponse("invoke finished successfully", ByteString.copyFrom("", UTF_8).toByteArray());


    }

    private Response getPrivate(ChaincodeStub stub, List<String> args) {


        return newSuccessResponse("invoke finished successfully", ByteString.copyFrom("", UTF_8).toByteArray());


    }

    private Response getChannelID(ChaincodeStub stub, List<String> args) {


        return newSuccessResponse("invoke finished successfully", ByteString.copyFrom("", UTF_8).toByteArray());


    }

    private Response getBinding(ChaincodeStub stub, List<String> args) {


        return newSuccessResponse("invoke finished successfully", ByteString.copyFrom("", UTF_8).toByteArray());


    }

    private Response getTransient(ChaincodeStub stub, List<String> args) {


        return newSuccessResponse("invoke finished successfully", ByteString.copyFrom("", UTF_8).toByteArray());


    }

    private Response getCreator(ChaincodeStub stub, List<String> args) {


        return newSuccessResponse("invoke finished successfully", ByteString.copyFrom("", UTF_8).toByteArray());


    }

    private Response getSignedProposal(ChaincodeStub stub, List<String> args) {


        return newSuccessResponse("invoke finished successfully", ByteString.copyFrom("", UTF_8).toByteArray());


    }

    private Response getTxTimeStamp(ChaincodeStub stub, List<String> args) {


        return newSuccessResponse("invoke finished successfully", ByteString.copyFrom("", UTF_8).toByteArray());


    }

    private Response setStateValidationParameter(ChaincodeStub stub, List<String> args) {


        return newSuccessResponse("invoke finished successfully", ByteString.copyFrom("", UTF_8).toByteArray());


    }

    private Response getStateValidationParameter(ChaincodeStub stub, List<String> args) {


        return newSuccessResponse("invoke finished successfully", ByteString.copyFrom("", UTF_8).toByteArray());


    }


}
