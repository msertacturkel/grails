package restprofile

import grails.rest.Resource

@Resource(uri='/category')
class Category {

    String catName
    static hasMany = [articles:Article]

    static constraints = {
        catName blank:false
    }
}