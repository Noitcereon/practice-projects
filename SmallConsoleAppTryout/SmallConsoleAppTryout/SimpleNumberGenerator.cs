using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SmallConsoleAppTryout
{
    public class SimpleNumberGenerator
    {
        private static Random _random = new Random(DateTime.Now.Millisecond);
        private SimpleNumberGenerator()
        {
            // To hide the public constructor
        }

        /// <param name="min">The min value (inclusive)</param>
        /// <param name="max">The max value (inclusive)</param>
        /// <returns>A number between min and max (inclusive)</returns>
        public static int GenerateRandomNumber(int min, int max)
        {
            int maxPlusOne = max + 1;
            
            return _random.Next(min, maxPlusOne);
        }
        public static String BuildRandomNumberString(int numbersToGenerate = 50)
        {
            StringBuilder sb = new StringBuilder(64);
            for (int i = 0; i < numbersToGenerate; i++)
            {
                int nextNumber = GenerateRandomNumber(0, 1);
                sb.Append(nextNumber).Append(',');
            }
            int lastIndex = sb.Length - 1;
            sb.Remove(lastIndex, 1);
            return sb.ToString();
        }
    }
}
