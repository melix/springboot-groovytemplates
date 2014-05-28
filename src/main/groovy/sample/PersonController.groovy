package sample

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.servlet.ModelAndView

@Controller
@RequestMapping("/person")
class PersonController {

    @RequestMapping("list")
    def list() {
        new ModelAndView('views/person/list', [persons: Person.list()])
    }

    @RequestMapping("add")
    def add() {
        new ModelAndView('views/person/edit', [person: new Person()])
    }

    @RequestMapping("{id}")
    def view(@PathVariable("id") Long id) {
        new ModelAndView("views/person/edit", "person", Person.get(id))
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView save(Person person) {
        if (person.id) {
            // update
            def p = person.get(person.id)
            p.with {
                firstName = person.firstName
                lastName = person.lastName
                save()
            }
        } else {
            person.save()
        }
        new ModelAndView("redirect:/person/list")
    }

}
