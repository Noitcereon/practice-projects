using Microsoft.VisualStudio.TestTools.UnitTesting;
using SmallConsoleAppTryout;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SmallConsoleAppTryout.Tests
{
    [TestClass()]
    public class SimpleNumberGeneratorTests
    {
        [TestInitialize]
        public void Init()
        {
            
        }

        [TestMethod()]
        public void GivenRangeOneToTwo_WhenGeneratatingNumber_ThenNeitherGoesBelow40Percent()
        {
            int countOfNumberOne = 0;
            int countOfNumberTwo = 0;
            for (int i = 0; i < 100; i++)
            {
                int nextNumber = SimpleNumberGenerator.GenerateRandomNumber(1, 2);
                if (nextNumber == 1) countOfNumberOne++;
                if(nextNumber == 2) countOfNumberTwo++;
            }
            Assert.IsTrue(40 < countOfNumberOne);
            Assert.IsTrue(40 < countOfNumberTwo);
        }

        [TestMethod()]
        public void GivenNothing_WhenBuildingRandomNumberString_ThenLengthIs99()
        {
            int expected = 99; // 50 numbers + 49 comma
            int actual = SimpleNumberGenerator.BuildRandomNumberString().Length;
            Assert.AreEqual(expected, actual);
        }
    }
}