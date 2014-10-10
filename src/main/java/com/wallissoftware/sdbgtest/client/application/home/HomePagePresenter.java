package com.wallissoftware.sdbgtest.client.application.home;

import javax.inject.Inject;

import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.wallissoftware.sdbgtest.client.application.ApplicationPresenter;
import com.wallissoftware.sdbgtest.client.place.NameTokens;

import elemental.dom.Document;
import elemental.dom.Node;
import elemental.xpath.DOMParser;

public class HomePagePresenter extends Presenter<HomePagePresenter.MyView, HomePagePresenter.MyProxy> {
    interface MyView extends View {

        void setParaString(String string);
    }
    
    private static final String sample = "<head></head><body><p>test</p></body>";

    @ProxyStandard
    @NameToken(NameTokens.home)
    interface MyProxy extends ProxyPlace<HomePagePresenter> {
    }

    @Inject
    HomePagePresenter(EventBus eventBus, MyView view, MyProxy proxy) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_SetMainContent);
    }
    
    private static native DOMParser createDomParser() /*-{
        return new DOMParser();
    }-*/;

    @Override
    protected void onBind() {
        super.onBind();
        final Document doc = createDomParser().parseFromString(sample, "text/html");
        Node para = doc.getBody().getFirstChild();
        getView().setParaString(para.toString());
    }
    
    
}
