package com.example.demo.controller;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.apache.cxf.service.model.BindingInfo;
import org.apache.cxf.service.model.BindingOperationInfo;

import javax.xml.namespace.QName;
import java.util.Collection;


public class ServiceController {
    public static void main(String[] args) throws Exception {
            final String xmlTemplate = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r" + "<Q_Message>\r"
                    + "  <SenderID>%s</SenderID>\r" + "  <ServiceID>%s</ServiceID>\r" + "  <ServiceDescript>\r"
                    + "    <ServiceName>%s</ServiceName>\r" + "    <ReqData><![CDATA[%s]]></ReqData>\r"
                    + "  </ServiceDescript>\r" + "</Q_Message>";
         final String senderID = "C10-00000002";
            final String serviceId = "S10-00000002";

        final String method = "query";// 调用服务方接口的方法名

        final String queryParams = "1233333333";// 假如方法定义是 String query(String xml)，单个参数 ,queryParams 调用服务方接口方法的参数内容 ,

        // 假如方法定义是 String query(String arg1,String arg2) queryParams 应该是 json 格式 {"arg1":"121","arg2":"1212"}

        final String xml = String.format(xmlTemplate, senderID, serviceId, method, queryParams);

        System.out.println(xml);

        final JaxWsDynamicClientFactory clientFactory = JaxWsDynamicClientFactory.newInstance();
        final Client client = clientFactory.createClient(
                "http://192.168.81.110:7777/dataex/query_noland2?wsdl"
//                "http://192.168.137.1:8888/services/TestService?wsdl"
        );
        Object[] result = null;
        try {
            final Object[] parameters = new Object[] {
                    xml
            };
            // 获取op
            final Endpoint endpoint = client.getEndpoint();
            final BindingInfo info = endpoint.getEndpointInfo().getBinding();
            final Collection<BindingOperationInfo> operations = info.getOperations();
            QName op = null;
            for (final BindingOperationInfo bindingOperationInfo : operations) {
                final QName opQName = bindingOperationInfo.getOperationInfo().getName();
                if (opQName.getLocalPart().equals("query")) {
                    op = opQName;
                    //System.out.println(opQName);
                    break;
                }
            }
            result = client.invoke(op, parameters);
        } catch (final Exception e) {
            e.printStackTrace();
        }
       System.out.println(result[0]);
    }
}
