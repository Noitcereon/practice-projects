using CSharpRestAPI.DataAccess;
using ModelLib;
using System.Data;

namespace CSharpRestAPI.Services
{
    public class GameService : ICrud<Game, GamePost, String>
    {
        IDbConnection _dbConnection;

        public GameService(IDbConnection dbConnection)
        {
            _dbConnection = dbConnection;
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
            throw new NotImplementedException();
        }

        public Game Update(String id, Game updatedModel)
        {
            throw new NotImplementedException();
        }

        // TODO: Implement GameService & an interface for default CRUD.

    }
}
