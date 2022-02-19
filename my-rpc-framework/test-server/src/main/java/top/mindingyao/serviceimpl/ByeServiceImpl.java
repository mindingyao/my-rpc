package top.mindingyao.serviceimpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.mindingyao.annotation.Service;
import top.mindingyao.api.ByeObject;
import top.mindingyao.api.ByeService;

@Service
public class ByeServiceImpl implements ByeService {

    @Override
    public String bye(String name) {
        return "bye, " + name;
    }
}
