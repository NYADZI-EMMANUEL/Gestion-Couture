package context;

import service.ApprovisionnementService;
import service.ArticleConfectionService;
import service.VenteService;
import service.ClientService;
import service.ProductionService;
import service.ArticleVenteService;

public class AppContext {
    public static final ApprovisionnementService approvisionnementService = new ApprovisionnementService();
    public static final ArticleConfectionService articleConfectionService = new ArticleConfectionService();
    public static final VenteService venteService = new VenteService();
    public static final ClientService clientService = new ClientService();
    public static final ProductionService productionService = new ProductionService();
    public static final ArticleVenteService articleVenteService = new ArticleVenteService();
}
