package infra.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "takeaway-permission")
public interface AuthorizationClient  {

    @RequestMapping(method = RequestMethod.POST, value = "/verifytoken")
    String verifyToken(@RequestParam String token);

}
