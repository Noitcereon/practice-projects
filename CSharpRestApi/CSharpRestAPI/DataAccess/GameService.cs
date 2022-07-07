using CSharpRestAPI.DataAccess;
using CSharpRestAPI.Helpers;
using ModelLib;
using System.Data;
using System.Data.SqlClient;

namespace CSharpRestAPI.Services
{
    public class GameService : ICrud<Game, GamePost, String>
    {
        IDbConnection _dbConnection;

        public GameService()
        {
            _dbConnection = AppConfig.RetrieveDefaultConnection();
        }
        public GameService(String connectionString)
        {
            _dbConnection = new SqlConnection(connectionString);
        }

        public Game Create(GamePost modelToCreate)
        {
            try
            {
                Game game = new Game(modelToCreate);

                using (SqlCommand command = (SqlCommand)_dbConnection.CreateCommand())
                {
                    command.CommandText = "INSERT INTO Game VALUES(@Id, @Title, @Description, @ReleaseYear, @Price)";

                    command.Parameters.AddWithValue("@Id", game.Id);
                    command.Parameters.AddWithValue("@Title", game.Title);
                    command.Parameters.AddWithValue("@Description", game.Description);
                    command.Parameters.AddWithValue("@ReleaseYear", game.ReleaseYear);
                    command.Parameters.AddWithValue("@Price", game.Price);

                    _dbConnection.Open();
                    int rowsAffected = command.ExecuteNonQuery();
                    if (rowsAffected == 1) return game;
                    else throw new Exception("Not enough rowsaffected.");
                }
            }
            finally
            {
                _dbConnection.Close();
            }
        }

        public Game Delete(String id)
        {
            throw new NotImplementedException();
        }

        public Game Get(String id)
        {
            throw new NotImplementedException();
        }

        public IEnumerable<Game> GetAll()
        {
            var games = new List<Game>();
            using (IDbConnection dbConnection = _dbConnection)
            {
                var sqlCommand = dbConnection.CreateCommand();
                sqlCommand.CommandText = "SELECT * FROM Game";
                dbConnection.Open();
                var reader = sqlCommand.ExecuteReader();
                while (reader.Read())
                {
                    Game game = ModelConverter<Game>.Convert(reader);
                    games.Add(game);
                }
                dbConnection.Close();
            }
            return games;
        }

        public Game Update(String id, Game updatedModel)
        {
            throw new NotImplementedException();
        }

    }
}
