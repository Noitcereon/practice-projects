using System.Data;
using System.Data.SqlClient;

namespace CSharpRestAPI.Helpers
{
    public class AppConfig
    {
        private const String DEFAULT_CONNECTIONSTRING_ENV_VARIABLE = "DefaultConnectionString";

        public static IDbConnection RetrieveDefaultConnection()
        {
            IDbConnection dbConn = new SqlConnection(Environment.GetEnvironmentVariable(DEFAULT_CONNECTIONSTRING_ENV_VARIABLE));

            return dbConn;
        }
    }
}
