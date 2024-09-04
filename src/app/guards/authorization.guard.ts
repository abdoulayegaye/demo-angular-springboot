import {
  ActivatedRouteSnapshot,
  CanActivate,
  CanActivateFn,
  GuardResult,
  MaybeAsync, Router,
  RouterStateSnapshot
} from '@angular/router';
import {Injectable} from "@angular/core";
import {AuthenticationService} from "../services/authentication.service";

@Injectable()
export class AuthorizationGuard {

  constructor(private authService: AuthenticationService, private router : Router) {
  }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): MaybeAsync<GuardResult> {
    let authorize: boolean = false
    let authorizedRoles : string[] = route.data['roles'];
    let roles : string[] = this.authService.roles as string[]
    for (let role of roles){
      if(authorizedRoles.includes(role))
        authorize = true
    }
    return authorize
  }
}

/*export const auhtGuard: CanActivateFn = (route, state) => {
  return true;
};*/
