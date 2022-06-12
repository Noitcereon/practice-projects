﻿using CSharpRestAPI.DataAccess;
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
            throw new NotImplementedException();
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
                    var game = new Game(
                        id: reader.GetString(reader.GetOrdinal("Id")),
                        title: reader.GetString(reader.GetOrdinal("Title")),
                        description: reader.GetString(reader.GetOrdinal("Description")),
                        releaseYear: reader.GetString(reader.GetOrdinal("ReleaseYear")),
                        price: reader.GetDecimal(reader.GetOrdinal("Price")));
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

        // TODO: Implement GameService & an interface for default CRUD.

    }
}
