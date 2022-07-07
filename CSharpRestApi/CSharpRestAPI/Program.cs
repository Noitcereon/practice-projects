using CSharpRestAPI.DataAccess;
using CSharpRestAPI.Helpers;
using CSharpRestAPI.Services;
using ModelLib;
using System.Data;

#region Setup app to use .env file
String root = Directory.GetCurrentDirectory();
String dotenvFilePath = Path.Combine(root, ".env");
DotEnv.Load(dotenvFilePath);
#endregion

var builder = WebApplication.CreateBuilder(args);

// Add services to the container.
builder.Services.AddScoped <ICrud<Game, GamePost, string>, GameService>();

builder.Services.AddControllers();
// Learn more about configuring Swagger/OpenAPI at https://aka.ms/aspnetcore/swashbuckle
builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen();


WebApplication? app = builder.Build();

// Configure the HTTP request pipeline.
if (app.Environment.IsDevelopment())
{
    app.UseSwagger();
    app.UseSwaggerUI();
}

app.UseHttpsRedirection();

app.UseAuthorization();
app.MapControllers();

app.Run();
