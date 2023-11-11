
Matrikelnummer: 7239202

Recyclables like Paper, Plastic and Metal have no separate classes. They have been distinguished using enum types:

P: Paper
M: Metal
S: Plastic

Chain of Responsibility
-----------------------
The above recyclables are separated based on their enums. The separation of each recyclable is carried out by the Chain
of Responsibility. Each recyclable passes first through the metal separation process. Heavy metals are separated first.
If recyclable is a plastic it is separated by the successor of metal separation process namely the plastic separation
process since this type is a bit heavier than papers. The paper separation process is set as successor of the
plastic separation process and is carried out at last.

metal separation -> plastic separation -> paper separation

Visitor
-------------------
Box is considered to be a visitor since its capacity is changed everytime it visits a recyclable.
Recyclables are considered to be acceptors.


Observer
-------------------
The control room is a listener and listens to sensors fitted in boxes of respective processes carried out by the
conveyor. The Sensor sets alarm as soon as the box reaches maximum capacity. Box is then exchanged by a factory worker.


Testing
----------------
Test Application through TestApplication in src/test/java/recyclingFactory
Generated reports can be found as html in target/cucumber-html-report.html




