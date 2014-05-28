yieldUnescaped '<!DOCTYPE html>'
html {
    head {
        title('Spring Boot - Groovy templates example')
        link(rel: 'stylesheet', href: '/css/bootstrap.min.css')
    }
    body {
        div(class: 'container') {
            div(class: 'navbar') {
                div(class: 'navbar-inner') {
                    a(class: 'brand',
                            href: 'http://beta.groovy-lang.org/docs/groovy-2.3.2/html/documentation/markup-template-engine.html',
                            'Groovy - Template Engine docs')
                    a(class: 'brand',
                            href: 'hhttp://projects.spring.io/spring-boot/') {
                        yield 'Spring Boot docs'
                    }
                }
            }

            form (id:'editForm', action:'/person', method:'post') {
                input(name: 'id', type: 'hidden', value: person.id ?: '')
                label(for: 'firstName', 'First name')
                input(name: 'firstName', type: 'text', value: person.firstName ?: '')
                label(for: 'lastName', 'Last name')
                input(name: 'lastName', type: 'text', value: person.lastName ?: '')
                div(class: 'form-actions') {
                    input(type: 'submit', value: 'Submit')
                }
            }
        }
    }
}
