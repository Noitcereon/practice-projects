// See https://aka.ms/new-console-template for more information

using SmallConsoleAppTryout;

Console.WriteLine("Hello, World!");


Task taskOne = Task.Run(() => Console.WriteLine(SimpleNumberGenerator.BuildRandomNumberString()));
Task taskTwo =Task.Run(() => Console.WriteLine(SimpleNumberGenerator.BuildRandomNumberString()));
Task taskThree =Task.Run(() => Console.WriteLine(SimpleNumberGenerator.BuildRandomNumberString()));
Task taskFour = Task.Run(() => Console.WriteLine(SimpleNumberGenerator.BuildRandomNumberString()));

Task.WaitAny(taskOne, taskTwo, taskThree, taskFour);

Console.WriteLine("Exiting in 2 seconds");
int secondsToSleep = 2;
Thread.Sleep(secondsToSleep*1000);
