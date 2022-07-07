using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ModelLib
{
    public class GamePost : BaseGame
    {
        public GamePost() { }
        public GamePost(String title, String description, String releaseYear, decimal price) : base(title, description, releaseYear, price)
        {

        }
    }
}
