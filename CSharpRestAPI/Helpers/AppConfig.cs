using System.Data;
using System.Data.SqlClient;

namespace CSharpRestAPI.Helpers
{
    public class AppConfig
    {
        private const String DEFAULT_CONNECTIONSTRING_ENV_VARIABLE = "DefaultConnectionString";

        public static IDbConnection RetrieveDefaultConnection()
        {
            String? connectionString = Environment.GetEnvironmentVariable(DEFAULT_CONNECTIONSTRING_ENV_VARIABLE);
            if (connectionString == null) throw new ArgumentNullException(nameof(connectionString));
            IDbConnection dbConn = new SqlConnection(connectionString);

            return dbConn;
        }
    }
}
