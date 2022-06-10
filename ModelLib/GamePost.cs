using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ModelLib
{
    public class GamePost
    {
        private String _releaseYear = "";
        private Decimal? _price;

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
        public decimal? Price { get => _price; set => _price = value; }
    }
}
