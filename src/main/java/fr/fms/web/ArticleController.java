package fr.fms.web;
import fr.fms.dao.ArticleRepository;
import fr.fms.dao.CategoryRepository;
import fr.fms.entities.Article;
import fr.fms.entities.ArticleDTO;
import fr.fms.entities.ArticleToUpdateDTO;
import fr.fms.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class ArticleController {
String articleString = "article";
    private final ArticleRepository articleRepository;
    private final CategoryRepository categoryRepository;
    @Autowired
    public ArticleController(ArticleRepository articleRepository, CategoryRepository categoryRepository){
        this.articleRepository = articleRepository;
        this.categoryRepository = categoryRepository;
    }

    // @RequestMapping(value="/index", method=RequestMethod.GET)
    @GetMapping("/index")
    public String index(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
                        @RequestParam(name = "keyword", defaultValue = "") String kw) { //le model est fourni par spring, je peux l'utiliser comme ci


        // ! Affichage des articles (avec mot clé ou non "")
        Page<Article> articles = articleRepository.findByDescriptionContains(kw, PageRequest.of(page, 5));
        model.addAttribute("listArticle", articles.getContent());
        model.addAttribute("pages", new int[articles.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", kw);



        // ! Affichage de la liste des catégories
        List<Category> listCategories = categoryRepository.findAll();
        System.out.println(listCategories);
        model.addAttribute("categories", listCategories);
        // return articles.html
        return "articles"; //cette méthode retourne au dispatcherServerlet une vue
    }

    // delete button methode
    @GetMapping("/delete")
    public String delete(Long id, int page, String keyword) {
        articleRepository.deleteById(id);
        return "redirect:/index?page=" + page + "&keyword=" + keyword;
    }

    // add new article
    @GetMapping("/article")
    public String article(Model model) {
        // on inject un article par defaut dans le formulaire de saisi
        model.addAttribute(articleString, new Article());
        return articleString;
    }

    // update button methode
    @GetMapping("/update")
    public String update(Model model, Long id) {
        // on inject un article par defaut dans le formulaire de saisi
        Optional<Article> articleToUpdate = articleRepository.findById(id);
        Article article = articleToUpdate.orElse(null);
        model.addAttribute(articleString, article);
        return "update";
    }

    //New article save methode
    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("article") ArticleDTO articleDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return articleString;
        // s'il n'y a pas de saisie d'un champ selon certains critères, pas d'insertion en base
        Article article = new Article(articleDTO.getDescription(), articleDTO.getPrice());
        articleRepository.save(article);
        return "redirect:/index";
    }

    //article update methode
    @PostMapping("/toUpdate")
    public String toUpdate(Long id, @Valid @ModelAttribute("updatedArticle")ArticleToUpdateDTO updatedArticleDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return articleString;
        Optional<Article> articleToUpdate = articleRepository.findById(id);
        if (articleToUpdate.isPresent()){
            Article article = articleToUpdate.get();
            article.setId(updatedArticleDTO.getId());
            article.setDescription(updatedArticleDTO.getDescription());
            article.setPrice(updatedArticleDTO.getPrice());
            articleRepository.save(article);
        }
        return "redirect:/index";
    }
}