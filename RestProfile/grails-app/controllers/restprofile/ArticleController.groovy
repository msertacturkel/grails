package restprofile

import grails.validation.ValidationException
import org.springframework.beans.factory.annotation.Autowired

import static org.springframework.http.HttpStatus.*

class ArticleController {
    @Autowired
    Greeting g

    ArticleService articleService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond articleService.list(params), model:[articleCount: articleService.count()]
    }

    def show(Long id) {
        respond articleService.get(id)
    }

    def save(Article article) {
        if (article == null) {
            render status: NOT_FOUND
            return
        }

        try {
            articleService.save(article)
        } catch (ValidationException e) {
            respond article.errors, view:'create'
            return
        }

        respond article, [status: CREATED, view:"show"]
    }

    def update(Article article) {
        if (article == null) {
            render status: NOT_FOUND
            return
        }

        try {
            articleService.save(article)
        } catch (ValidationException e) {
            respond article.errors, view:'edit'
            return
        }

        respond article, [status: OK, view:"show"]
    }

    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        articleService.delete(id)

        render status: NO_CONTENT
    }
    def helloworld(){
        
    }
}
