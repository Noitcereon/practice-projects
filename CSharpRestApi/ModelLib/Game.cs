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
        public Game(String id, String title, String description, String releaseYear, Decimal price)
                    : base(title, description, releaseYear, price)
        {
            Id = id;
        }
        public Game(GamePost gamePost) : base(gamePost.Title, gamePost.Description, gamePost.ReleaseYear, 0)
        {
            Id = Guid.NewGuid().ToString();
            if(gamePost.Price != null) Price = gamePost.Price;
        }


        public String Id { get; set; }
    }
}
