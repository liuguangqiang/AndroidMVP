AndroidMVP
==================
AndroidMVP is a library for using MVP more easy in android.

##[MVP](http://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93presenter``)
Model–view–presenter (MVP) is a derivation of the model–view–controller (MVC) architectural pattern, and is used mostly for building user interfaces.

MVP is a user interface architectural pattern engineered to facilitate automated unit testing and improve the separation of concerns in presentation logic:

The model is an interface defining the data to be displayed or otherwise acted upon in the user interface.
The view is a passive interface that displays data (the model) and routes user commands (events) to the presenter to act upon that data.
The presenter acts upon the model and the view. It retrieves data from repositories (the model), and formats it for display in the view.

##Sample.

###Model

```
public class MainModel {

    public String getShowHello() {
        return "Hi! I am MVP.";
    }

    public String getSuccessTxt() {
        return "Congratulation!";
    }
    
}
```

###View
```
public interface MainUi extends BaseUi<MainUiCallback> {

    void showHello(String HelloMVP);

    void showSignSuccess(String txt);
    
}

```

###Presenter

```
public class MainPresenter extends Presenter<MainUi, MainUiCallback> {

    private MainModel mMainModel;

    public MainPresenter(Context context) {
        mMainModel = new MainModel();
    }

    @Override
    protected void populateUi(MainUi ui) {
        ui.showHello(mMainModel.getShowHello());
    }

    @Override
    protected MainUiCallback createUiCallback(final MainUi ui) {
        return new MainUiCallback() {
            @Override
            public void login(String username, String password) {
                //TODO implement login
                ui.showSignSuccess(mMainModel.getSuccessTxt());
            }
        };
    }
    
}

```

##Usage

###Gradle
```
dependencies {
   	compile 'com.github.liuguangqiang.mvp:library:+'
}
```

###Maven
```
<dependency>
  	<groupId>com.github.liuguangqiang.mvp</groupId>
  	<artifactId>library</artifactId>
  	<version>1.0.0</version>
  	<type>aar</type>
</dependency>
```
