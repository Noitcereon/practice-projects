import MyJavaApi from "./MyJavaApiService";

const retrieveActorsAsync = async ()=> {
    // TODO: define the full request, including the JWT token.
    // TODO: define return type of this metod.
    const response = await fetch(`${MyJavaApi.baseUrl}/actors`) 
    const result = await response.json();

    console.table(result);
}


const ActorService = {
    retrieveActors: retrieveActorsAsync
}
export default ActorService;