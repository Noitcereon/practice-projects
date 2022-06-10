using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ModelLib
{
    public class Game : BaseGame
    {

        public Game()
        {
            Id = Guid.NewGuid().ToString();
        }
        public Game(String title, String description, String releaseYear, Decimal price)
                    : base(title, description, releaseYear, price)
        {
            Id = Guid.NewGuid().ToString();
        }


        public String Id { get; set; }
    }
}
