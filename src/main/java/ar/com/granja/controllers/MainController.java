package ar.com.granja.controllers;

import java.security.Principal;
import java.util.LinkedList;
import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ar.com.granja.Chicken;
import ar.com.granja.Farm;
import ar.com.granja.bo.ChickenBO;
import ar.com.granja.bo.GranjaBO;
import ar.com.granja.bo.UsuarioBO;
import ar.com.granja.dto.FarmDTO;
import ar.com.granja.dto.SaveChickenDTO;
import ar.com.granja.dto.UsuarioDTO;

@Controller
public class MainController {

	private GranjaBO granjaBO;

	private ChickenBO chickenBO;
	
	private UsuarioBO usuarioBO;
	

	public UsuarioDTO crearUsuario(){
		User principal = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UsuarioDTO usuarioDTO = usuarioBO.obtenerUsuario(principal.getUsername());
		return usuarioDTO;
	}
	
	
	@RequestMapping("inicio.htm")
	public ModelAndView inicio() {

		ModelAndView mav = new ModelAndView("/inicio");
		return mav;
	}

	private List<FarmDTO> procesFarm(List<Farm> farms) {
		List<FarmDTO> farmsDTO = new LinkedList<FarmDTO>();
		for (Farm farm : farms) {

			FarmDTO farmDTO = new FarmDTO();
			farmDTO.setFarmId(farm.getIdFarm());
			farmDTO.setName(farm.getName());
			if (farm.getChickens().size() != 0) {
				farmDTO.setChickenCount(farm.getChickens().size());
				int chickenEggCount = 0;
				for (Chicken chicken : farm.getChickens()) {

					chickenEggCount = chickenEggCount + chicken.getEggs();
				}
				farmDTO.setEggCount(chickenEggCount);
			}

			farmsDTO.add(farmDTO);

		}
		return farmsDTO;

	}

	@RequestMapping("eliminarGranja.htm")
	public @ResponseBody String eliminarGranja(String idFarm) {

		try {
			granjaBO.eliminarGranja(Integer.parseInt(idFarm));
		} catch (Exception e) {
			e.printStackTrace();
			return "false";
		}
		return "true";

	}

	@RequestMapping("addChicken.htm")
	public @ResponseBody String addChicken(String name, int eggs, int idFarm) {
		SaveChickenDTO chickenDTO = new SaveChickenDTO();
		chickenDTO.setName(name);
		chickenDTO.setEggs(eggs);
		chickenDTO.setIdFarm(idFarm);
		try {
			chickenBO.guardarGallinaEnGranja(chickenDTO);
		} catch (Exception e) {
			e.printStackTrace();
			return "false";

		}
		return "true";

	}

	@RequestMapping("deleteChicken.htm")
	public ModelAndView deleteChicken(Chicken chickenDTO) {
		ModelAndView mav = new ModelAndView("exito/eliminarGallinaExito");
		chickenBO.eliminarGallina(chickenDTO);
		return mav;
	}

	@RequestMapping("administrarGranjas.htm")
	public ModelAndView administrarGranjas() {
		ModelAndView mav = new ModelAndView("/administrar/administrarGranjas");
		
						List<Farm> farms = granjaBO.hayGranjas(crearUsuario().getIdUser());

		List<FarmDTO> farmsDTO = procesFarm(farms);
		mav.addObject("farms", farmsDTO);
		mav.addObject("formFarm", new Farm());
	
		return mav;

	}

	@RequestMapping("verGranja.htm")
	public ModelAndView verGranja(Farm farmDTO) {
		ModelAndView mav = new ModelAndView("administrar/verGranja");

//		Farm farm = granjaBO.obtenerGranjaPorNombre(farmDTO);
				List<Chicken> chickens = chickenBO.obtenerPollitosDeGranja(farmDTO);
				farmDTO.setChickens(chickens);
		
		Chicken chickenDTO = new Chicken();
		mav.addObject("chickenDTO", chickenDTO);
		mav.addObject("farm", farmDTO);

		return mav;

	}

	@RequestMapping("agregarGallina.htm")
	public ModelAndView agregarGallina(Farm farm) {

		ModelAndView mav = new ModelAndView("administrar/agregarGallina");
		SaveChickenDTO chickenDTO = new SaveChickenDTO();
		chickenDTO.setIdFarm(farm.getIdFarm());
		mav.addObject("chickenDTO", chickenDTO);
		return mav;

	}

	@RequestMapping("createFarm.htm")
	public ModelAndView menuPrincipal(ModelMap model) {
		Farm farm = new Farm();
		ModelAndView mav = new ModelAndView("/agregarGranja");
		mav.addObject("farm", farm);
		return mav;
	}

	@RequestMapping("modificarGallinaForm.htm")
	public ModelAndView modificarGallinaForm(String name, String eggs, String idFarm, String idChicken) {

		ModelAndView mav = new ModelAndView("modal/modificarGallinaModal");
		Chicken chicken = new Chicken();
		chicken.setEggs(Integer.parseInt(eggs));
		chicken.setIdChicken(Integer.parseInt(idChicken));
		chicken.setIdFarm(Integer.parseInt(idFarm));
		chicken.setName(name);
		mav.addObject("chickenDTO", chicken);

		return mav;

	}

	@RequestMapping("updateChicken.htm")
	public ModelAndView updateChicken(Chicken chickenDTO) {

		ModelAndView mav = new ModelAndView("exito/gallinaModificada");

		chickenBO.modificarGallina(chickenDTO);
		return mav;

	}

	@RequestMapping("saveFarm.htm")
	public ModelAndView createFarm(Farm farm) {
		ModelAndView mav = new ModelAndView("/granjaCreada");
		farm.setUserID(crearUsuario().getIdUser());
		if (farm.getName() != "" && farm.getName() != null) {
			try {
				granjaBO.crearGranja(farm);

			} catch (org.springframework.dao.DuplicateKeyException e) {
				// TODO Auto-generated catch block
				return new ModelAndView("errores/errorGranjaExistente");
			}
			mav.addObject("nombre", farm.getName());

		}
		return mav;
	}

	public GranjaBO getGranjaBO() {
		return granjaBO;
	}

	public void setGranjaBO(GranjaBO granjaBO) {
		this.granjaBO = granjaBO;
	}

	public ChickenBO getChickenBO() {
		return chickenBO;
	}

	public void setChickenBO(ChickenBO chickenBO) {
		this.chickenBO = chickenBO;
	}


	public UsuarioBO getUsuarioBO() {
		return usuarioBO;
	}


	public void setUsuarioBO(UsuarioBO usuarioBO) {
		this.usuarioBO = usuarioBO;
	}


	

}
