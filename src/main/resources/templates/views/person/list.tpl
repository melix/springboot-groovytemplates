layout 'layouts/main.tpl',
        pageTitle: 'List persons',
        mainBody: contents {
            ul {
                persons.each { person ->
                    li {
                        a(href:"/person/$person.id", "$person.lastName $person.firstName")
                    }
                }
            }

            div {
                a(href:'/person/add', 'Add new person')
            }
        }
