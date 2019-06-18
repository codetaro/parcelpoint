A robotic arm places boxes in 5 columns (A, B, C, D, E) each with height 10 boxes. The default position for the arm is before column A. 

- The command F makes the arm move forward along the rows. 
- The command D causes the load to be dropped. The load must be a string value that is required to be surrounded by {} following a D command. 
- The command R causes the arm to go back to default position.

Dropping the load on a full column or the default position leads to nothing happening. Once a load is successfully dropped the arm moves forward one position except when in the last column where nothing happens. The arm cannot move ahead of the last column and will stay there if it receives a forward command.

Any other command is ignored and the robot stays in its current position. The commands are case sensitive.

Using the package structure provided, implement the `public Map<String, List> simulateArm(final String input)` method in the Robot class.

The `simulateArm` method should accept the commands as a string and returns the state of the columns as a `Map<String, List>`.

E.g.

`Robot robot = new Robot();`<br/> 
`Map<String, List> output = robot.simulateArm("FD{foo}FFD{bar}RFFD{Foo}RFFD{World}D{}DA{hello}");`<br/> 
`// prints {A=[foo], B=[Foo, World], C=[], D=[bar, hello], E=[]} to the console`<br/>
`System.out.println(output.toString());`

Your free to add to the files, classes, pom, dependencies, etc, as you require.

Implement your test cases in the RobotTest class. Your free to use any testing framework(s) of your choice.

Please include instructions on how to run your unit tests.

**Applied OO Patterns**

- _**Strategy**_: defines a family of robots, each extends the Robot abstract class, and makes them interchangeable as a component of the ParcelPoint class.
- Either **_Command_**: encapsulates a command as an object, thereby letting you parameterize ParcelPoints with different commands, queue or log commands, and support undoable operations.
- Or **_Template Method_**: define the skeleton of simulateArm algorithm, deferring some steps to subclasses of the Robot abstract class. Template Method lets subclasses redefine certain steps of simulateArm without changing the algorithm's structure.