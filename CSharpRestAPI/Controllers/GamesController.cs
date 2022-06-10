using CSharpRestAPI.DataAccess;
using CSharpRestAPI.Services;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using ModelLib;
using System.Diagnostics;

namespace CSharpRestAPI.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class GamesController : ControllerBase
    {
        private readonly ILogger<GamesController> _logger;
        private readonly ICrud<Game, GamePost, String> _gameService;

        public GamesController(ILogger<GamesController> logger, ICrud<Game, GamePost, String> gameService)
        {
            _logger = logger;
            _gameService = gameService;
        }

        [HttpGet]
        public IActionResult GetAll()
        {
            if (Debugger.IsAttached) _logger.LogInformation("Get All Games was called");
           
            return Ok(_gameService.GetAll());
        }
    }
}
