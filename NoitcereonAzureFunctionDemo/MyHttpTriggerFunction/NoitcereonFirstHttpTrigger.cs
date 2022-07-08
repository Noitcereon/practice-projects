using System;
using System.IO;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Azure.WebJobs;
using Microsoft.Azure.WebJobs.Extensions.Http;
using Microsoft.AspNetCore.Http;
using Microsoft.Extensions.Logging;
using Newtonsoft.Json;
using System.Net.Http;

namespace MyHttpTriggerFunction
{
    public static class NoitcereonFirstHttpTrigger
    {
        // Route default = {url}/api/{functionName}
        // Route for this would function would be: localhost://7071/api/NoitcereonFirstHttpTrigger
        [FunctionName("NoitcereonFirstHttpTrigger")]
        public static async Task<IActionResult> Run(
            [HttpTrigger(AuthorizationLevel.Function, "post", Route = null)] HttpRequest req,
            ILogger log)
        {
            log.LogInformation("NoitcereonFirstHttpTrigger processed a request.");
            HttpClient http = new HttpClient();
            HttpRequestMessage httpRequest = new HttpRequestMessage();
            httpRequest.RequestUri = new Uri("https://v2.jokeapi.dev/joke/Programming,Pun");
            HttpResponseMessage response = await http.SendAsync(httpRequest);
            if (response.IsSuccessStatusCode)
            {
                DateTime dateTime = DateTime.Now;
                HttpContent content = response.Content;
                String json = await content.ReadAsStringAsync();

                dynamic deserializedJoke = JsonConvert.DeserializeObject(json);

                String output = $"Setup: {deserializedJoke.setup}, Delivery: {deserializedJoke.delivery}, RequestTime: {dateTime}";
                log.LogInformation($"Returning: {output}");
                return new OkObjectResult(output);
            }
            else
            {
                log.LogError("Failed request with status code 500");
                return new StatusCodeResult(500);
            }
        }
    }
}
