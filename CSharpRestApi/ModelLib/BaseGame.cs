using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ModelLib
{
    public abstract class BaseGame
    {
        private decimal? _price;
        private String _releaseYear = "";
        public BaseGame()
        {
        }
        public BaseGame(String title, String description, String releaseYear, Decimal price)
        {
            Title = title;
            Description = description;
            ReleaseYear = releaseYear;
            Price = price;
        }


        public String Title { get; set; } = "";
        public String Description { get; set; } = "";
        public String ReleaseYear
        {
            get => _releaseYear;
            set
            {
                if (value.Length > 4) throw new ArgumentException("Release year must be 4 or less characters");
                _releaseYear = value;
            }
        }
        public decimal? Price
        {
            get => _price; set
            {
                if (value < 0) throw new ArgumentException("Price cannot be less than 0");
                _price = value;
            }
        }
    }
}
