package demo.spring;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
    
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
    
    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        logger.info("Welcome home! The client locale is {}.", locale);
        
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, Locale.GERMANY);
        
        String formattedDate = dateFormat.format(date);
        
        model.addAttribute("serverTime", formattedDate + " Hello, Spring!");
        
        return "home"; //~ the jsp page name to return as a view
    }


    @RequestMapping(value = "/go", method = RequestMethod.GET)
    public String go(Locale locale, Model model) {
        logger.info("Go! The client locale is {}.", locale);
        
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, Locale.GERMAN);
        
        String formattedDate = dateFormat.format(date);
        
        model.addAttribute("serverTime", formattedDate);
        
        return "go"; //~ the jsp page name to return as a view
    }
    
    
    @RequestMapping(value = "/snoop", method = RequestMethod.GET)
    public String snoop() {
        return "snoop"; //~ the jsp page name to return as a view
    }
    
}
