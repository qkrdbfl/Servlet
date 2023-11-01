package com.ohgiraffers.section03.requestlistener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class RequestListenerTest implements ServletRequestListener, ServletRequestAttributeListener {

    public RequestListenerTest() {
        /* context가 로드될 떄 생성자 호출하여 인스턴스는 생성된다. */
        System.out.println("request listener 인스턴스 생성");
    }

    public void requestDestroyed(ServletRequestEvent sre)  {
        /* request가 소멸될 때 호출된다. */
        System.out.println("request destoryed!!");
    }

    public void attributeRemoved(ServletRequestAttributeEvent srae)  {
        /* request에 attribute가 제거될 때 호출된다. */
        System.out.println("request attribute removed!!"); //톰캣쪽에서 자동으로 수정돼서 매번 호출되는것이니 크게 신경쓰지 않아도 된다
    }

    public void requestInitialized(ServletRequestEvent sre)  {
        /* request가 생성될 때 호출된다. */
        System.out.println("request init!!");
    }

    public void attributeAdded(ServletRequestAttributeEvent srae)  {
        /* request에 attribute가 추가될 때 호출된다. */
        System.out.println("request attribute added!!");
    }

    public void attributeReplaced(ServletRequestAttributeEvent srae)  {
        /* request에 attribute가 갱신될 때 호출된다. */
        /* org.apache.catalina.ASYNC_SUPPORTED라는 attribute가 자동 수정되기 때문에 한 번 호출은 된다.
         * 서블릿 3.0에서부터 비동기 방식의 요청 처리를 지원한다는 내용이니 너무 신경쓰지는 말자
         * */
        System.out.println("request attribute replaced!!");
        System.out.println(srae.getName() + ", " + srae.getValue());
    }

}