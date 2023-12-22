import { useState } from "react";

let BASE_URL = 'http://localhost:9937/customer';

export function CustomerProfileRegistration() {
    let [firstName, setFirstName] = useState('');
    let [lastName, setLastName] = useState('');
    let [email, setEmail] = useState(''); 
    let [password, setPassword] = useState('');
    let [pan,setPan] = useState('');
    let [phone, setPhone] = useState('');
    
    //handler to store the form data -ill write the code inside it after creating the forms
    let store = (e) => {
        e.preventDefault();
        // axios calls the HTTP post method
        axios.post(BASE_URL+'/'+'register', { "firstName": firstName,"lastName":lastName,"email":email ,"password": password,"pan":pan, "phone": phone })
            .then(r => {
                setEmail(r.data.email);
                setMessage(`Profile Stored with email :${r.data.email}`);
                setFirstName('');setLastName('') ;setEmail('');setPassword(''); setPan(''); setPhone('');
            })
            .catch(err => console.log(err))
    }
    return (<div className="w-25">
        <form onSubmit={store}>
            <div>
                <input type="text" placeholder="Enter First Name" autoComplete="off" value={firstName}
                    className="form-control" onChange={e => setFirstName(e.target.value)} />
            </div>
            <div>
                <input type="text" placeholder="Enter Last Name" autoComplete="off" value={lastName}
                    className="form-control" onChange={e => setLastName(e.target.value)} />
            </div>
            <div>
                <input type="email" placeholder="Enter Email" autoComplete="off" value={email}
                    className="form-control" onChange={e => setEmail(e.target.value)} />
            </div>
            <div>
                <input type="password" placeholder="Enter Password" autoComplete="off" value={password}
                    className="form-control" onChange={e => setPassword(e.target.value)} />
            </div>
            <div>
                <input type="text" placeholder="Enter Pan Number" autoComplete="off" value={pan}
                    className="form-control" onChange={e => setPan(e.target.value)} />
            </div>
            <div>
                <input type="text" placeholder="Enter Phone number" autoComplete="off" value={phone}
                    className="form-control" onChange={e => setPhone(e.target.value)} />
            </div>
            
            <div>
                <input type="submit" value='Register' className="btn btn-secondary" />
                <input type="reset" value='Reset' className="btn btn-secondary" />
            </div>
            <div>
                {id != '' ? <div className="text-success">{message}</div> : <div></div>}
            </div>
        </form>
    </div>

    )
}