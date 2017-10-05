package com.foo.umbrella.ui.code;

public class CodePresenter implements CodeContract.Presenter{

    CodeContract.View caView;

    public CodePresenter(CodeContract.View codeView){
        caView = codeView;
    }

    @Override
    public void getCity(String city) {

    }
}
