import 'package:flutter/material.dart';

void main() => runApp(BullseyeApp());

class BullseyeApp extends StatelessWidget {
    @override
    Widget build(BuildContext context) {
        return MaterialApp(
            title: 'BullsEye',
            theme: ThemeData(primarySwatch: Colors.blue),
            home: GamePage(title: 'BullsEye'),
        );
    }
}

class GamePage extends StatefulWidget{
    GamePage({Key key,this.title}): super(key : key);
    final String title;

    @override
    _GamePageState createState()=> _GamePageState();
}

class _GamePageState extends State<GamePage>{
    @override
    Widget build(BuildContext context){
        return Scaffold(
          body: Center(
              child: Column(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: <Widget>[
                      Text(
                          "My first flutter app BullsEye",
                          style: TextStyle(fontWeight: FontWeight.bold, color: Colors.green),
                      ),
                      TextButton(
                          child: Text('Hit me!',style: TextStyle(color: Colors.blue)),
                          onPressed: (){},
                      )
                  ],
              ),
          ),
        );
    }
}