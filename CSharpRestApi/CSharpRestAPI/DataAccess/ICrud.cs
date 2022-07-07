namespace CSharpRestAPI.DataAccess
{
    /// <summary>
    /// Data access interface, that expects the use of a Data Transfer Object and an Id on the entity object
    /// </summary>
    /// <typeparam name="T">The entity to make CRUD (Create-Read-Update-Delete) for.</typeparam>
    /// <typeparam name="Dto">The model used by consumers to post (Dto = Data Transfer Object)</typeparam>
    /// <typeparam name="IdType">The ID type of the model in question. Typically <c>int</c> or <c>string</c></typeparam>
    public interface ICrud<T, Dto, IdType> where T : class, new() where Dto : class, new()
    {
        IEnumerable<T> GetAll();
        T Get(IdType id);
        T Create(Dto modelToCreate);
        T Update(IdType id, T updatedModel);
        T Delete(IdType id);
    }
}
