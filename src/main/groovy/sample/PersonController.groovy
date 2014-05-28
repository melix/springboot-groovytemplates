/*
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
