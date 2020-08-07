package ru.mg.accountservice;

import java.util.concurrent.Future;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;

/**
 * This class was generated by Apache CXF 3.3.1
 * 2020-08-07T11:51:08.864+03:00
 * Generated source version: 3.3.1
 *
 */
@WebService(targetNamespace = "http://mg.ru/accountservice", name = "AccountService")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface AccountService {

    @WebMethod(operationName = "GetAccountDetails")
    public Response<ru.mg.accountservice.AccountDetailsResponse> getAccountDetailsAsync(
        @WebParam(partName = "parameters", name = "AccountDetailsRequest", targetNamespace = "http://mg.ru/accountservice")
        AccountDetailsRequest parameters
    );

    @WebMethod(operationName = "GetAccountDetails")
    public Future<?> getAccountDetailsAsync(
        @WebParam(partName = "parameters", name = "AccountDetailsRequest", targetNamespace = "http://mg.ru/accountservice")
        AccountDetailsRequest parameters,
        @WebParam(name = "asyncHandler", targetNamespace = "")
        AsyncHandler<ru.mg.accountservice.AccountDetailsResponse> asyncHandler
    );

    @WebMethod(operationName = "GetAccountDetails", action = "http://mg.ru/Accounts/GetAccountDetails")
    @WebResult(name = "AccountDetailsResponse", targetNamespace = "http://mg.ru/accountservice", partName = "parameters")
    public AccountDetailsResponse getAccountDetails(
        @WebParam(partName = "parameters", name = "AccountDetailsRequest", targetNamespace = "http://mg.ru/accountservice")
        AccountDetailsRequest parameters
    );
}
