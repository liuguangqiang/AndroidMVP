AndroidMVP
==================
AndroidMVP is a library for using MVP more easy in android.

##[MVP](http://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93presenter``)
Model–view–presenter (MVP) is a derivation of the model–view–controller (MVC) architectural pattern, and is used mostly for building user interfaces.

MVP is a user interface architectural pattern engineered to facilitate automated unit testing and improve the separation of concerns in presentation logic:

The model is an interface defining the data to be displayed or otherwise acted upon in the user interface.
The view is a passive interface that displays data (the model) and routes user commands (events) to the presenter to act upon that data.
The presenter acts upon the model and the view. It retrieves data from repositories (the model), and formats it for display in the view.

##Usage

###Gradle
```
dependencies {
   	compile 'com.github.liuguangqiang.mvp:library:0.1.0'
}
```

###Maven
```
<dependency>
  	<groupId>com.github.liuguangqiang.mvp</groupId>
  	<artifactId>library</artifactId>
  	<version>0.1.0</version>
  	<type>aar</type>
</dependency>
```
