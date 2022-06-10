using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using System.Diagnostics;

namespace CSharpRestAPI.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class GamesController : ControllerBase
    {
        private readonly ILogger<GamesController> _logger;

        public GamesController(ILogger<GamesController> logger)
        {
            _logger = logger;
        }

        [HttpGet]
        public IActionResult GetAll()
        {
            if (Debugger.IsAttached) _logger.LogInformation("Get All Games was called");
           
            return Ok("Hello World");
        }
    }
}
