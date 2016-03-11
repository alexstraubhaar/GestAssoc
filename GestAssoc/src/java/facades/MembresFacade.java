/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.Membres;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author lucas.beltrame
 */
@Stateless
public class MembresFacade extends AbstractFacade<Membres> {
    @PersistenceContext(unitName = "GestAssocPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MembresFacade() {
        super(Membres.class);
    }
    
}
