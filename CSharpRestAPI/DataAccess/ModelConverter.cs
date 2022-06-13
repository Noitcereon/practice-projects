using ModelLib;
using System.Data;

namespace CSharpRestAPI.DataAccess
{
    public class ModelConverter<T> where T : class, new()
    {
        public static T Convert(IDataReader reader)
        {
            Type type = typeof(T);

            try
            {
                T? outputObject = new T();
                switch (type.Name)
                {
                    case "Game":
                        outputObject = ParseGame(reader) as T;
                        break;
                    default: throw new Exception("Unhandled type");
                }
                if (outputObject == null) throw new NullReferenceException();
                return outputObject;
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex);
                throw;
            }
        }

        private static Game ParseGame(IDataReader reader)
        {
            return new Game(id: reader.GetString(reader.GetOrdinal("Id")),
                        title: reader.GetString(reader.GetOrdinal("Title")),
                        description: reader.GetString(reader.GetOrdinal("Description")),
                        releaseYear: reader.GetString(reader.GetOrdinal("ReleaseYear")),
                        price: reader.GetDecimal(reader.GetOrdinal("Price")));
        }
    }
}
