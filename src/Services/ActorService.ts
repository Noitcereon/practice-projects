import MyJavaApi from "./MyJavaApiService";

const retrieveActorsAsync = async ()=> {
    const response = await fetch(`${MyJavaApi.baseApiUrl}`)
    const result = await response.json();

    console.table(result);
}


const ActorService = {
    retrieveActors: retrieveActorsAsync
}
export default ActorService;