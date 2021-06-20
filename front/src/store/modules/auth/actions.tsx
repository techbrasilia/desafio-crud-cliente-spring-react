export function signInRequest(username:string, password:string) {
    return {
        type: '@auth/SIGN_IN_REQUEST',
        payload: { username, password },
    };
}

export function signInSuccess(token:string, user:any) {
    return {
        type: '@auth/SIGN_IN_SUCCESS',
        payload: { token, user },
    };
}

export function signUpRequest(name:string, username:string, password:string) {
    return {
        type: '@auth/SIGN_UP_REQUEST',
        payload: { name, username, password },
    };
}

export function signFailure() {
    return {
        type: '@auth/SIGN_FAILURE',
    };
}

export function signOut() {
    return {
        type: '@auth/SIGN_OUT',
    };
}
