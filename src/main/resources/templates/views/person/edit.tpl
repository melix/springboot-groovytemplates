layout 'layouts/main.tpl',
        pageTitle: 'Edit Person',
        mainBody: contents {
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