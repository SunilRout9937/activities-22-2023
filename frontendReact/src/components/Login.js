import { useState } from "react";
import { Link, Route, Routes, useNavigate, useParams } from "react-router-dom";

let BASE_URL = 'http://localhost:9937/customer';
export function CustomerProfileLogin() {
    
    let [email, setEmail] = useState(''); 
    let [password, setPassword] = useState('');
    let [error, setError] = useState(''); //If profile not found set this error
    let navigate = useNavigate();

    //callback to login by only id
    let loginById = (e) => {
        e.preventDefault();
        //send only id to the backend, in then() call useNavigate() to navigate programatically
        axios.get(BASE_URL + '/' + 'login',{})
            .then(res => navigate('/success/' + id))
            .catch(e => {
                console.log(e);
                setId('');
                setError(e.response.data.error);
            });
    };


    return (<div className="w-25">
        <h2> Login Form</h2> <hr />
        <form onSubmit={loginById}>
            <input type='number' autoComplete="off" className="form-control"
                value={id} onChange={e => setId(e.target.value)} />
            <input type="submit" value='Login' className="btn btn-secondary" />
            <div>
                {error != '' ? <div className="text-danger">{error}</div> : <div></div>}
            </div>
            <div>
                <Link to='/register'>Create Profile</Link>
            </div>
        </form>
    </div>)

}